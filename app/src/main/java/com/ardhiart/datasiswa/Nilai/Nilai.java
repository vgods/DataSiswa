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
    NilaiAdapter nilaiAdapter;
    RecyclerView rvNilai;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.nilai_fragment, container, false);
        rvNilai = (RecyclerView) v.findViewById(R.id.rv_nilai);
        nilaiAdapter = new NilaiAdapter();
        rvNilai.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNilai.setAdapter(nilaiAdapter);
        nilaiAdapter.initData(getContext());
        return v;
    }

    public static Nilai newInstance() {
        
        Bundle args = new Bundle();
        
        Nilai fragment = new Nilai();
        fragment.setArguments(args);
        return fragment;
    }
}
