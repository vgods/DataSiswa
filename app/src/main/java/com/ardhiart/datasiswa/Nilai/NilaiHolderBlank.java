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
public class NilaiHolderBlank extends BaseNilaiHolder {
    public NilaiHolderBlank(View itemView) {
        super(itemView);
    }
    public NilaiHolderBlank(ViewGroup parent){
        this(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_blank, parent, false));
    }

}
