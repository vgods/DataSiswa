package com.ardhiart.datasiswa.User;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ardhiart.datasiswa.API.Model.Siswa;
import com.ardhiart.datasiswa.Auth.Auth;
import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.MainActivity;
import com.ardhiart.datasiswa.R;

import java.util.Random;

/**
 * Created by Hinata on 10/15/2017.
 */
public class UserFragment extends BaseFragment{
    TextView txtNama, txtUsername, txtEmail, txtLahir, txtAlamat, txtNo, txtDesc, txtInitial;
    View round;
    Button btnLogOut;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_fragment, container, false);
        txtNama = (TextView) v.findViewById(R.id.txt_name);
        txtUsername = (TextView) v.findViewById(R.id.txt_username);
        txtEmail = (TextView) v.findViewById(R.id.txt_email);
        txtLahir = (TextView) v.findViewById(R.id.txt_lahir);
        txtAlamat = (TextView) v.findViewById(R.id.txt_alamat);
        txtNo = (TextView) v.findViewById(R.id.txt_no);
        txtDesc = (TextView) v.findViewById(R.id.txt_desc);
        txtInitial = (TextView) v.findViewById(R.id.initial);
        round = v.findViewById(R.id.round);
        btnLogOut = (Button) v.findViewById(R.id.btn_logout);

        Siswa siswa = Auth.getLoginInformation(getContext());

        txtNama.setText(siswa.getNama());
        txtUsername.setText(siswa.getUsername());
        txtEmail.setText(siswa.getEmail());
        txtLahir.setText(siswa.getTanggal_lahir());
        txtAlamat.setText(siswa.getAlamat());
        txtNo.setText(siswa.getNo());
        txtDesc.setText(siswa.getDesc());

        txtInitial.setText(siswa.getNama().substring(0, 2));
        int[] warna = {Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN};
        round.setBackgroundTintList(ColorStateList.valueOf(warna[new Random().nextInt(warna.length-1)]));

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.logOut(getContext());
                restartActivity();
            }
        });

        return v;
    }

    private void restartActivity(){
        Intent i = new Intent(getContext(), MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public static UserFragment newInstance() {
        
        Bundle args = new Bundle();
        
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
