package com.ardhiart.datasiswa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Hinata on 10/14/2017.
 */
public class BaseFragment extends Fragment {

    public boolean hasToolbar(){
        return true;
    }

    public android.support.v7.widget.Toolbar getToolbar(){
        return null;
    }

    public boolean isViewPager(){
        return false;
    }

    public void setTabLayout(TabLayout tabLayout){

    }

    public void setTransparentStatusBar(){
        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.transparent));
    }

    public void setNotTransparentStatusBar(){
        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.colorPrimaryDark));
    }
}
