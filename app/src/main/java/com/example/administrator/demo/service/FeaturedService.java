package com.example.administrator.demo.service;



import android.util.Log;

import com.example.administrator.demo.api.FeaturedApi;

import com.example.administrator.demo.data.FeatureData;
import com.example.administrator.demo.fragment.Featured;
import com.example.administrator.demo.inter.featured.OnRequestPhotoListen;
import com.example.administrator.demo.tools.AuthInterceptor;
import com.example.administrator.demo.utils.Resplash;

import com.google.gson.GsonBuilder;


import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/9/1.
 */

public class FeaturedService {
    private Call call;


    public static FeaturedService getInstanceFeaturedService(){
        return new FeaturedService();
    }
    public void requestPhotos(int start, int count ,final OnRequestPhotoListen photoListen){
        Call<FeatureData> getPhotos = buildApi(buildClient()).getPhotos(start,count);
        getPhotos.enqueue(new Callback<FeatureData>() {
            @Override
            public void onResponse(Call<FeatureData> call, Response<FeatureData> response) {
                    if (photoListen !=null){
                        photoListen.onRequestPhotoSuccess(call,response);
                    }
            }

            @Override
            public void onFailure(Call<FeatureData> call, Throwable t) {
          if (photoListen != null){
              photoListen.onRequestPhotoFailed(call,t);
          }
            }
        });

        call = getPhotos;

    }

public void cancle(){
    if (call != null){
        call.cancel();
    }
}
private OkHttpClient buildClient(){

    return new OkHttpClient.Builder()
            .addInterceptor(new AuthInterceptor()).build();
}
private FeaturedApi buildApi(OkHttpClient client){
    return new Retrofit.Builder().baseUrl(Resplash.DOU_BAN)
            .client(client).addConverterFactory(GsonConverterFactory.create()).
                    build().create(FeaturedApi.class);


}


}
