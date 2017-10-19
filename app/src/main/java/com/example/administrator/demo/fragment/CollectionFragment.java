package com.example.administrator.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2017/8/28.
 */

public class CollectionFragment extends Fragment {

     private TextView textView;
    //单例，模式，防止内存的消耗
    public static CollectionFragment newInstance(){
        CollectionFragment collectionFragment = new CollectionFragment();
        return collectionFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View collectionView = inflater.inflate(R.layout.collection_fragment,container,false);
        textView = (TextView) collectionView.findViewById(R.id.collevtion_text);
        textView.setText("four");


        return collectionView;
    }
}
