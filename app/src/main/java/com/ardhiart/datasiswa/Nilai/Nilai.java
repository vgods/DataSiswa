package com.ardhiart.datasiswa.Nilai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.R;

/**
 * Created by Hinata on 10/14/2017.
 */
public class Nilai extends BaseFragment {

    RecyclerView rvNilai;
    boolean onSingleMapel = false;
    String mapelId = "";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.nilai_fragment, container, false);
        rvNilai = (RecyclerView) v.findViewById(R.id.rv_nilai);
        rvNilai.setLayoutManager(new LinearLayoutManager(getContext()));
        if (onSingleMapel){
            NilaiMapelAdapter nilaiMapelAdapter = new NilaiMapelAdapter(getContext(), mapelId);
            rvNilai.setAdapter(nilaiMapelAdapter);
            nilaiMapelAdapter.initData(getContext());
        }else {
            NilaiAdapter nilaiAdapter = new NilaiAdapter();
            rvNilai.setAdapter(nilaiAdapter);
            nilaiAdapter.initData(getContext());
        }
        return v;
    }

    public static Nilai newInstance() {
        
        Bundle args = new Bundle();
        
        Nilai fragment = new Nilai();
        fragment.onSingleMapel = false;
        fragment.setArguments(args);
        return fragment;
    }

    public static Nilai newInstance(String mapelId) {

        Bundle args = new Bundle();

        Nilai fragment = new Nilai();
        fragment.mapelId = mapelId;
        fragment.onSingleMapel = true;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public boolean isViewPager() {
        return false;
    }
}
