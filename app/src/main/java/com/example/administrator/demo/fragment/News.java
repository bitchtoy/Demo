package com.example.administrator.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2017/8/30.
 */

public class News extends Fragment {


    public static News newInstance(){
        News news = new News();
        return news;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View newsView = inflater.inflate(R.layout.news_fragment,container,false);



        return newsView;
    }
}
