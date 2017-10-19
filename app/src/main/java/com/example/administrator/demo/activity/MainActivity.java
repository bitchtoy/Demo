package com.example.administrator.demo.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.administrator.demo.R;
import com.example.administrator.demo.adpter.MainAdapter;
import com.example.administrator.demo.fragment.CollectionFragment;
import com.example.administrator.demo.fragment.Featured;
import com.example.administrator.demo.fragment.News;
import com.example.administrator.demo.utils.StaticData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MainAdapter mainAdapter;
    private List<Fragment> list;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.main_activity_tab);
        viewPager = (ViewPager)findViewById(R.id.main_activity_viewPage);
        toolbar = (Toolbar)findViewById(R.id.main_activity_tool);
        drawerLayout = (DrawerLayout)findViewById(R.id.main_activity_drawer);
        navigationView = (NavigationView)findViewById(R.id.mian_activity_navigation);
        fab = (FloatingActionButton)findViewById(R.id.main_activity_floatingActionButton);
        //toolbar设计
       //  setToolBar(toolbar);

        //viewPage的设计
        setViewPage(viewPager);

        //tab设计
        tabLayout.addTab(tabLayout.newTab().setText("Featured"));
        tabLayout.addTab(tabLayout.newTab().setText("News"));
        tabLayout.addTab(tabLayout.newTab().setText("Collection"));

        //添加tab 于 viewPage的交互
         tabLayout.setupWithViewPager(viewPager);
         //设置toolbar

        //返回控件的设计
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,
                toolbar,R.string.drawer_open,R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        setUpNavigation(navigationView);

    }


    private void setViewPage(ViewPager viewPager) {
        list = new ArrayList<>();
        list.add(Featured.newInstance());
        list.add(News.newInstance());
        list.add(CollectionFragment.newInstance());
        mainAdapter = new MainAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(mainAdapter);

    }


    private void setUpNavigation(NavigationView navigation){
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.featured:
                        viewPager.setCurrentItem(StaticData.FEATURE_FRAGMENT);
                        break;
                    case R.id.news:
                        viewPager.setCurrentItem(StaticData.FEATURE_NEWS);
                        break;
                    case R.id.collection:
                        viewPager.setCurrentItem(StaticData.FEATURE_COLLECTION);
                        break;
                    case R.id.support_development:

                        break;
                    case R.id.setting:

                        break;
                    case R.id.about:

                        break;

                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
//    private void setToolBar(Toolbar toolBar) {
//        toolBar.inflateMenu(R.menu.toolbar_ico);
//        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                return true;
//            }
//        });
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_ico,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
        }else {
            super.onBackPressed();
        }

    }
}
