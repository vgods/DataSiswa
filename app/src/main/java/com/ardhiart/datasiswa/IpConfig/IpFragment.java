package com.ardhiart.datasiswa.IpConfig;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ardhiart.datasiswa.API.ServiceGenerator;
import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.MainActivity;
import com.ardhiart.datasiswa.R;

/**
 * Created by Hinata on 10/25/2017.
 */
public class IpFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.set_ip_fragment, container, false);
        final TextView txtIp = (TextView) v.findViewById(R.id.ip);
        Button btnSet = (Button) v.findViewById(R.id.btn_set);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceGenerator.API_BASE_URL = "http://"+txtIp.getText()+":3000/api/";
                Intent i = new Intent(getContext(), MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        return v;
    }

    @Override
    public boolean hasToolbar() {
        return false;
    }
}
