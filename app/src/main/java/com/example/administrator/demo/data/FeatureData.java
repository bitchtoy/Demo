package com.example.administrator.demo.data;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.demo.R;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public class FeatureData{
    public int count;
    public int start;
    public int total;
    public List<Subjects> subjects;
}
