package com.ardhiart.datasiswa;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Hinata on 10/14/2017.
 */
public class BaseActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    BaseFragment baseFragment;
    ImageView btnBack;
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public void syncToolbar(){
        appBarLayout.removeAllViews();
        appBarLayout.addView(LayoutInflater.from(this).inflate(R.layout.toolbar, appBarLayout, false));
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.removeAllViews();
        toolbar.addView(LayoutInflater.from(this).inflate(R.layout.toolbar_items, toolbar, false));
        btnBack = (ImageView) findViewById(R.id.btn_back);
        showBackButton();

        if (baseFragment.isViewPager()) syncTabLayout();
    }

    private void syncTabLayout(){
        appBarLayout.addView(LayoutInflater.from(this).inflate(R.layout.tab_layout, appBarLayout, false));
        baseFragment.setTabLayout((TabLayout) findViewById(R.id.tabs));
    }

    private void showBackButton(){
        if(fragmentManager.getBackStackEntryCount() > 1)
            btnBack.setVisibility(View.VISIBLE);
        else
            btnBack.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() <= 1){
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }else {
            baseFragment = (BaseFragment) fragmentManager.getFragments().get(fragmentManager.getBackStackEntryCount()-2);
            super.onBackPressed();
        }
    }

    public void showSnackBar(String text){
        Snackbar.make(this.getCurrentFocus(), text, Snackbar.LENGTH_SHORT).show();
    }

}
