package com.ardhiart.datasiswa.Nilai;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ardhiart.datasiswa.R;

/**
 * Created by Hinata on 10/16/2017.
 */
public class NilaiHolder extends BaseNilaiHolder {
    TextView txtNama, txtMapel, txtScore, txtMulai;
    View round, item;
    public NilaiHolder(View itemView) {
        super(itemView);
        item = itemView;
        txtNama = (TextView) itemView.findViewById(R.id.nama_tugas);
        txtMapel = (TextView) itemView.findViewById(R.id.mapel);
        txtScore = (TextView) itemView.findViewById(R.id.score);
        txtMulai = (TextView) itemView.findViewById(R.id.mulai);
        round = itemView.findViewById(R.id.round);
        txtMapel.setText("");

    }
    public NilaiHolder(ViewGroup parent){
        this(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_nilai, parent, false));
    }

}
