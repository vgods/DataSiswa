package com.ardhiart.datasiswa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hinata on 10/14/2017.
 */
public class Toolbar extends BaseFragment {
    android.support.v7.widget.Toolbar toolbar;
    View toolbarItems;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.toolbar, container, false);
        toolbar = (android.support.v7.widget.Toolbar) v.findViewById(R.id.toolbar);
        toolbarItems = inflater.inflate(R.layout.toolbar_items, container, false);
        toolbar.removeAllViews();
//        toolbar.addView(toolbarItems);

        return v;
    }

    @Override
    public android.support.v7.widget.Toolbar getToolbar() {
        return toolbar;
    }

    public void showToolbar(){
        if (toolbar == null) return;
        toolbar.setVisibility(View.VISIBLE);
    }

    public void hideToolbar(){
        if (toolbar == null) return;
        toolbar.setVisibility(View.GONE);
    }
}
