package com.ardhiart.datasiswa.Nilai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.R;

/**
 * Created by Hinata on 10/14/2017.
 */
public class Nilai extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_nilai, container, false);
        return v;
    }

    public static Nilai newInstance() {
        
        Bundle args = new Bundle();
        
        Nilai fragment = new Nilai();
        fragment.setArguments(args);
        return fragment;
    }
}
