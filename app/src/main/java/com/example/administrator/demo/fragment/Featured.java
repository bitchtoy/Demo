package com.example.administrator.demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.administrator.demo.R;
import com.example.administrator.demo.activity.FearturedDetails;
import com.example.administrator.demo.adpter.FeatureAdapter;
import com.example.administrator.demo.data.FeatureData;
import com.example.administrator.demo.data.Subjects;
import com.example.administrator.demo.inter.featured.FeaturedItemListener;
import com.example.administrator.demo.inter.featured.OnRequestPhotoListen;
import com.example.administrator.demo.service.FeaturedService;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import tr.xip.errorview.ErrorView;

/**
 * Created by Administrator on 2017/8/30.
 */

public class Featured extends Fragment {

    private ProgressBar progressBar;
    private ErrorView errorView;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private List<Subjects> subjectses;
    private FeaturedService featuredService;
    private FeatureAdapter featureAdapter;

    private int mStart,mCount;
    public static Featured newInstance(){
        Featured featured = new Featured();
        return featured;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        featuredService = FeaturedService.getInstanceFeaturedService();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View featuredView = inflater.inflate(R.layout.feature_fragment,container,false);

        progressBar = (ProgressBar)featuredView.findViewById(R.id.featured_fragment_progress);
        errorView = (ErrorView) featuredView.findViewById(R.id.featured_fragment_error);
        refreshLayout = (SwipeRefreshLayout) featuredView.findViewById(R.id.featured_fragment_swipe);
        recyclerView = (RecyclerView) featuredView.findViewById(R.id.feature_fragment_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);



        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchNew();
            }
        });

        fetchNew();
        return featuredView;
    }

    private void upData(final List<Subjects> subjectses){
        featureAdapter = new FeatureAdapter(this.getContext(),subjectses);
        recyclerView.setAdapter(featureAdapter);
        featureAdapter.getFeaturedItemListener(new FeaturedItemListener() {
            @Override
            public void onFeaturedItemListen(View view, int position) {
                Intent intent = new Intent(getActivity(),FearturedDetails.class);
                Bundle bundle = new Bundle();
                bundle.putString("data",new Gson().toJson(subjectses));
                bundle.putInt("postion",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void fetchNew() {
        if (subjectses == null){
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            errorView.setVisibility(View.GONE);
        }
        mStart = 0;
        mCount = 20;

        OnRequestPhotoListen onRequestPhotoListen = new OnRequestPhotoListen() {
            @Override
            public void onRequestPhotoSuccess(Call<FeatureData> call, Response<FeatureData> response) {

                if (response.code()==200){
                  Log.d("----------->",response.body().total+"");
                  subjectses = response.body().subjects;
                    FeatureData jsonObject = response.body();
                    Featured.this.upData(subjectses);
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    errorView.setVisibility(View.GONE);
                }else {
                    errorView.setTitle(R.string.error_http);
                    errorView.setSubtitle(R.string.error_http_subtitle);
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                    errorView.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onRequestPhotoFailed(Call<FeatureData> call, Throwable throwable) {
                errorView.showRetryButton(false);
                errorView.setTitle(R.string.error_network);
                errorView.setSubtitle(R.string.error_network_subtitle);
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                errorView.setVisibility(View.VISIBLE);
                refreshLayout.setRefreshing(false);
            }

        };
        refreshLayout.setRefreshing(false);
        featuredService.requestPhotos(mStart,mCount,onRequestPhotoListen);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (featuredService != null){
            featuredService.cancle();
        }
    }
}
