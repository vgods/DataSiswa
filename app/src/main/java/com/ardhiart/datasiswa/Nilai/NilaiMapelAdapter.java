package com.ardhiart.datasiswa.Nilai;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.ardhiart.DateUtils;
import com.ardhiart.datasiswa.API.Model.Mapel;
import com.ardhiart.datasiswa.API.Model.NilaiDetail;
import com.ardhiart.datasiswa.API.Model.TugasMapel;
import com.ardhiart.datasiswa.API.Service.AccountsService;
import com.ardhiart.datasiswa.API.Service.Callback;
import com.ardhiart.datasiswa.API.Service.MapelService;
import com.ardhiart.datasiswa.API.Service.NilaiService;
import com.ardhiart.datasiswa.API.ServiceGenerator;
import com.ardhiart.datasiswa.Adapter.ListAdapter;
import com.ardhiart.datasiswa.Auth.Auth;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hinata on 10/16/2017.
 */
public class NilaiMapelAdapter extends ListAdapter<TugasMapel, BaseNilaiHolder> {
    MapelService mapelService;
    boolean onSingleMapel = false;
    String mapelId = "";
    Context context;

    public NilaiMapelAdapter(Context context, String mapelId){
        onSingleMapel = true;
        this.mapelId = mapelId;
        this.context = context;
        mapelService = ServiceGenerator.createService(MapelService.class);
    }

    @Override
    public BaseNilaiHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return viewType == 0 ? new NilaiHolderBlank(parent) : new NilaiHolder(parent);
    }

    @Override
    public int getItemViewType(int position) {
        TugasMapel tugasMapel = get(position);
        int indexNilai = isMyScore(tugasMapel.getNilais());
        return indexNilai >= 0 ? 1 : 0;
    }

    @Override
    public void onBindViewHolder(final BaseNilaiHolder h, int position) {
        TugasMapel tugasMapel = get(position);
        int indexNilai = isMyScore(tugasMapel.getNilais());
        if (indexNilai < 0){
            return;
        }
        NilaiHolder holder = (NilaiHolder) h;
        holder.item.setVisibility(View.VISIBLE);
        holder.txtNama.setText(tugasMapel.getNama());

        holder.txtMapel.setText(tugasMapel.getMapel().getNama());
        holder.txtMulai.setText(DateUtils.toNormal(tugasMapel.getMulai()));
        int score = Integer.parseInt(tugasMapel.getNilais().get(indexNilai).getScore());
        holder.txtScore.setText(""+score);
        if(score >= 60 && score < 70 ){
            holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        } else if(score >= 70 && score < 80 ){
            holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        } else if(score >= 80 && score < 90 ){
            holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(0, 203, 255)));
        }  else if(score >= 90){
            holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        } else holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
    }

    private int isMyScore(List<NilaiDetail> nilai){
        for (int i = 0; i < nilai.size(); i++){
            NilaiDetail n = nilai.get(i);
            if (n.getSiswaId().equals(Auth.getLoginInformation(context).getId())) return i;
        }
        return -1;
    }

    public void initData(Context context){
        ServiceGenerator.createService(NilaiService.class).getNilaiBySiswaMapel(mapelId, Auth.getLoginInformation(context).getId())
                .enqueue(new Callback<List<TugasMapel>>() {
                    @Override
                    public void onSucces(Call<List<TugasMapel>> call, Response<List<TugasMapel>> response) {
                        add(response.body());
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
