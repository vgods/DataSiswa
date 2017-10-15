package com.ardhiart.datasiswa.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ardhiart.datasiswa.Auth.Auth;
import com.ardhiart.datasiswa.BaseActivity;
import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.Home.HomeFragment;
import com.ardhiart.datasiswa.MainActivity;
import com.ardhiart.datasiswa.R;

/**
 * Created by Hinata on 10/14/2017.
 */
public class LoginFragment extends BaseFragment {
    Button btnLogin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_fragment, container, false);
        btnLogin = (Button) v.findViewById(R.id.btn_login);
        setTransparentStatusBar();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.login = true;
                Intent i = new Intent(getContext(), MainActivity.class);
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
