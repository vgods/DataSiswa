package com.ardhiart.datasiswa.Nilai;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hinata on 10/16/2017.
 */
public class NilaiAdapter extends ListAdapter<NilaiDetail, NilaiHolder> {
    MapelService mapelService;

    public NilaiAdapter(){
        mapelService = ServiceGenerator.createService(MapelService.class);
    }

    @Override
    public NilaiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NilaiHolder(parent);
    }

    @Override
    public void onBindViewHolder(final NilaiHolder holder, int position) {
        NilaiDetail nilaiDetail = get(position);
        holder.txtNama.setText(nilaiDetail.getTugas().getNama());
        holder.txtScore.setText(nilaiDetail.getScore());
        holder.txtMulai.setText(DateUtils.toNormal(nilaiDetail.getTugas().getMulai()));
        int score = Integer.parseInt(nilaiDetail.getScore());
        if(score >= 60 && score < 70 ){
            holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        } else if(score >= 70 && score < 80 ){
            holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        } else if(score >= 80 && score < 90 ){
            holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(0, 203, 255)));
        }  else if(score >= 90){
            holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        } else holder.round.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

        mapelService.getMapel(nilaiDetail.getTugas().getMapelId()).enqueue(new Callback<Mapel>() {
            @Override
            public void onSucces(Call<Mapel> call, Response<Mapel> response) {
                holder.txtMapel.setText(response.body().getNama());
            }

            @Override
            public void onError() {

            }
        });
    }

    public void initData(Context context){
        ServiceGenerator.createService(AccountsService.class).
                getNilais(Auth.getLoginInformation(context).getId()).
                enqueue(new Callback<List<NilaiDetail>>() {
                    @Override
                    public void onSucces(Call<List<NilaiDetail>> call, Response<List<NilaiDetail>> response) {
                        List<NilaiDetail> nilaiDetails = response.body();
                        Collections.reverse(nilaiDetails);
                        add(nilaiDetails);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
