package com.ardhiart.datasiswa.User;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.R;

/**
 * Created by Hinata on 10/15/2017.
 */
public class UserFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_fragment, container, false);
        return v;
    }

    public static UserFragment newInstance() {
        
        Bundle args = new Bundle();
        
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
