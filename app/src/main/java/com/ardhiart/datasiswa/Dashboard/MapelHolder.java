package com.ardhiart.datasiswa.Dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ardhiart.datasiswa.R;

/**
 * Created by Hinata on 10/16/2017.
 */
public class MapelHolder extends RecyclerView.ViewHolder {
    TextView txtNama, txtDesc, txtInitial;
    View round, item;
    public MapelHolder(View itemView) {
        super(itemView);
        item = itemView;
        txtNama = (TextView) itemView.findViewById(R.id.nama);
        txtDesc = (TextView) itemView.findViewById(R.id.desc);
        txtInitial = (TextView) itemView.findViewById(R.id.initial);
        round = itemView.findViewById(R.id.round);
    }
    public MapelHolder(ViewGroup parent){
        this(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mapel, parent, false));
    }

}
