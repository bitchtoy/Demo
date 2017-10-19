package com.example.administrator.demo.utils;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2017/9/15.
 */

public class Utils {

    public static int getToolbarHeight(Context context){
    final TypedArray styleAttributes = context.getTheme().obtainStyledAttributes(new int[]{
            R.attr.actionBarSize});
        int toolbarHeight = (int) styleAttributes.getDimension(0,0);
        styleAttributes.recycle();
        return toolbarHeight;


    }
}
