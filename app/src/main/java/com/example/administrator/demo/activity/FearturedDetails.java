package com.example.administrator.demo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.demo.R;
import com.example.administrator.demo.data.Casts;
import com.example.administrator.demo.data.FeatureData;
import com.example.administrator.demo.data.Subjects;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */

public class FearturedDetails extends AppCompatActivity{
    private int item_position;
    private final int defaultValue = 0;
    private List<Subjects> subjectses;
    private Toolbar toolbar;
    private ImageView user_img;
    private List<Casts> castses;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_details);
        toolbar = (Toolbar) findViewById(R.id.activity_featured_detail_toolbar);
        user_img = (ImageView)findViewById(R.id.activity_detail_img);
        Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material,getTheme());
        upArrow.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        Type listType = new TypeToken<List<Subjects>>(){}.getType();
        subjectses = new Gson().fromJson(bundle.getString("data"),listType);
        item_position = bundle.getInt("postion");
        castses = subjectses.get(item_position).casts;
        Glide.with(this).load(castses.get(0).avatars.small).into(user_img);

    }


}
