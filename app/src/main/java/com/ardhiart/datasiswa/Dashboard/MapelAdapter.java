package com.ardhiart.datasiswa.Dashboard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import com.ardhiart.DateUtils;
import com.ardhiart.datasiswa.API.Model.Mapel;
import com.ardhiart.datasiswa.API.Model.NilaiDetail;
import com.ardhiart.datasiswa.API.Service.AccountsService;
import com.ardhiart.datasiswa.API.Service.Callback;
import com.ardhiart.datasiswa.API.Service.MapelService;
import com.ardhiart.datasiswa.API.ServiceGenerator;
import com.ardhiart.datasiswa.Adapter.ListAdapter;
import com.ardhiart.datasiswa.Auth.Auth;
import com.ardhiart.datasiswa.MainActivity;
import com.ardhiart.datasiswa.Nilai.Nilai;
import com.ardhiart.datasiswa.Nilai.NilaiHolder;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hinata on 10/16/2017.
 */
public class MapelAdapter extends ListAdapter<Mapel, MapelHolder> {
    MapelService mapelService;
    MainActivity activity;

    public MapelAdapter(MainActivity activity){
        this.activity = activity;
        mapelService = ServiceGenerator.createService(MapelService.class);
    }

    @Override
    public MapelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MapelHolder(parent);
    }

    @Override
    public void onBindViewHolder(final MapelHolder holder, int position) {
        final Mapel mapel = get(position);

        holder.txtNama.setText(mapel.getNama());
        holder.txtDesc.setText(mapel.getDesc());
        holder.txtInitial.setText(mapel.getNama().substring(0, 2));
        int[] warna = {Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN};
        holder.round.setBackgroundTintList(ColorStateList.valueOf(warna[new Random().nextInt(warna.length-1)]));

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nilai nilai = Nilai.newInstance(mapel.getId());
                activity.replaceFragment(nilai);
            }
        });
    }

    public void initData(Context context){
            mapelService.getAllMapel().enqueue(new Callback<List<Mapel>>() {
                @Override
                public void onSucces(Call<List<Mapel>> call, Response<List<Mapel>> response) {
                    add(response.body());
                }

                @Override
                public void onError() {

                }
            });
    }
}
