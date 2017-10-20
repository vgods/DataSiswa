package com.ardhiart.datasiswa.Dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.MainActivity;
import com.ardhiart.datasiswa.R;

/**
 * Created by Hinata on 10/15/2017.
 */
public class MapelFragment extends BaseFragment {
    RecyclerView rvNilai;
    MapelAdapter mapelAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.nilai_fragment, container, false);
        rvNilai = (RecyclerView) v.findViewById(R.id.rv_nilai);
        mapelAdapter = new MapelAdapter((MainActivity) getActivity());
        rvNilai.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNilai.setAdapter(mapelAdapter);
        mapelAdapter.initData(getContext());
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public static MapelFragment newInstance() {
        Bundle args = new Bundle();

        MapelFragment fragment = new MapelFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
