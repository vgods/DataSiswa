package com.ardhiart.datasiswa;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ardhiart.datasiswa.Auth.Auth;
import com.ardhiart.datasiswa.Home.HomeFragment;
import com.ardhiart.datasiswa.Login.LoginFragment;
import com.ardhiart.datasiswa.Nilai.Nilai;

public class MainActivity extends BaseActivity implements FragmentManager.OnBackStackChangedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);
        if (!Auth.isLogin(this)){
            replaceFragment(new LoginFragment());
            return;
        }
        replaceFragment(new HomeFragment());

    }
    public void replaceFragment(Fragment f){
        baseFragment = (BaseFragment) f;
        fragmentManager.beginTransaction()
                .replace(R.id.container,f).addToBackStack(null)
                .commit();

    }

    public void replaceFragmentFromLogin(Fragment f){
        baseFragment = (BaseFragment) f;
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction()
                .replace(R.id.container,f).addToBackStack(null)
                .commit();


    }

    @Override
    public void onBackStackChanged() {
        if (baseFragment.hasToolbar()){
            syncToolbar();
        } else {
            if (appBarLayout.getChildCount() > 0) appBarLayout.removeAllViews();
        }
    }


}
