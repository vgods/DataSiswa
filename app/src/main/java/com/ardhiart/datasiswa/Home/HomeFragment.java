package com.ardhiart.datasiswa.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ardhiart.datasiswa.Auth.Auth;
import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.Dashboard.MapelFragment;
import com.ardhiart.datasiswa.Home.Adapter.ViewPagerAdapter;
import com.ardhiart.datasiswa.Nilai.Nilai;
import com.ardhiart.datasiswa.R;
import com.ardhiart.datasiswa.User.UserFragment;

/**
 * Created by Hinata on 10/15/2017.
 */
public class HomeFragment extends BaseFragment{
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pager, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        setNotTransparentStatusBar();
        return v;
    }

    @Override
    public boolean isViewPager() {
        return true;
    }

    @Override
    public void setTabLayout(TabLayout tabLayout) {
        this.tabLayout = tabLayout;
        initTabLayout();
    }

    private void initTabLayout(){
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(Nilai.newInstance(), "Nilai");
        adapter.addFragment(MapelFragment.newInstance(), "Mapel");
        adapter.addFragment(UserFragment.newInstance(), Auth.getLoginInformation(getContext()).getNama());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
