package com.example.administrator.demo.adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.demo.R;
import com.example.administrator.demo.activity.FearturedDetails;
import com.example.administrator.demo.data.Casts;
import com.example.administrator.demo.data.FeatureData;
import com.example.administrator.demo.data.Subjects;
import com.example.administrator.demo.inter.featured.FeaturedItemListener;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Administrator on 2017/9/12.
 */

public class FeatureAdapter  extends RecyclerView.Adapter<FeatureAdapter.ViewHolder> {
    private Context context;
    private List<Subjects> subjectses;
    private List<Casts> castses;
    public FeaturedItemListener itemListener;
    public FeatureAdapter(Context context,List<Subjects> subjectses){
        this.context = context;
        this.subjectses = subjectses;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.feature_fragment_item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view,itemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Glide.with(context).load(castses.get(position).avatars.large).into(holder.imageView);
     castses = subjectses.get(position).casts;
        for (int i = 0;i<castses.size();i++){
            Glide.with(context).load(castses.get(i).avatars.large).into(holder.imageView);
            holder.textView.setText(castses.get(i).id+castses.get(i).name);
        }
    }

    @Override
    public int getItemCount() {
        return subjectses.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;
        CardView cardView;
        FeaturedItemListener itemListener;
        public ViewHolder(View itemView,FeaturedItemListener itemListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.feature_fragment_item_img);
            textView = itemView.findViewById(R.id.feature_fragment_item_text);
            cardView = itemView.findViewById(R.id.feature_fragment_item_card);
            cardView.setBackgroundResource(R.drawable.item_listen);
            itemView.setOnClickListener(this);
            this.itemListener = itemListener;
        }


        @Override
        public void onClick(View view) {
          itemListener.onFeaturedItemListen(itemView,getPosition());
        }
    }
    public void getFeaturedItemListener(FeaturedItemListener itemListener){
        this.itemListener = itemListener;
    }
}
