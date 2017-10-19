package com.example.administrator.demo.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */

public class MainAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String>  titleList;
    private String[] toolBars = {"Featured","News","Collection"};
    public MainAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list = list;

    }



    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return toolBarsTitle().get(position);
    }
    private List<String> toolBarsTitle(){
        titleList = new ArrayList<>();
        for (int i = 0;i<toolBars.length;i++){
            titleList.add(toolBars[i]);
        }

        return titleList;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
