package com.example.administrator.demo.utils;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/9/15.
 */

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {
    private int toolbarHeight;

    public ScrollAwareFABBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        toolbarHeight = Utils.getToolbarHeight(context);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency) || dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        if (dependency instanceof AppBarLayout){
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)
                    child.getLayoutParams();
            int fabBottomMargin = layoutParams.bottomMargin;
            int distanceToScroll = child.getHeight()+fabBottomMargin;
            float ratio= dependency.getY()/toolbarHeight;
            child.setTranslationY(-distanceToScroll*ratio);
        }
        return true;

    }
}
