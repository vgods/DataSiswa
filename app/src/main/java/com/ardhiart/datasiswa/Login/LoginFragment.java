package com.ardhiart.datasiswa.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ardhiart.datasiswa.API.Model.LoginRequest;
import com.ardhiart.datasiswa.API.Model.LoginResponse;
import com.ardhiart.datasiswa.API.Model.Siswa;
import com.ardhiart.datasiswa.API.Service.AccountsService;
import com.ardhiart.datasiswa.API.Service.Callback;
import com.ardhiart.datasiswa.API.ServiceGenerator;
import com.ardhiart.datasiswa.Auth.Auth;
import com.ardhiart.datasiswa.BaseActivity;
import com.ardhiart.datasiswa.BaseFragment;
import com.ardhiart.datasiswa.Home.HomeFragment;
import com.ardhiart.datasiswa.MainActivity;
import com.ardhiart.datasiswa.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hinata on 10/14/2017.
 */
public class LoginFragment extends BaseFragment {
    ProgressDialog progressDialog;
    Button btnLogin;
    EditText editUsername, editPassword;
    AccountsService accountsService;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_fragment, container, false);
        ((MainActivity)getActivity()).checkServer();
        btnLogin = (Button) v.findViewById(R.id.btn_login);
        editUsername = (EditText) v.findViewById(R.id.username);
        editPassword = (EditText) v.findViewById(R.id.password);
        setTransparentStatusBar();
        accountsService = ServiceGenerator.createService(AccountsService.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
        return v;
    }

    @Override
    public boolean hasToolbar() {
        return false;
    }

    private void Login(){
        showProgresDoalog();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(editUsername.getText().toString());
        loginRequest.setPassword(editPassword.getText().toString());

        accountsService.Login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onSucces(Call<LoginResponse> call, Response<LoginResponse> response) {
                getAccount(response.body().getUserId());
            }

            @Override
            public void onError() {
                progressDialog.dismiss();
                ((BaseActivity)getActivity()).showSnackBar("Login Failed");
            }
        });
    }

    private void getAccount(String id){
        accountsService.getAccount(id).enqueue(new Callback<Siswa>() {
            @Override
            public void onSucces(Call<Siswa> call, Response<Siswa> response) {
                Auth.saveLoginInformation(response.body(), getContext());
                progressDialog.dismiss();
                restartActivity();
            }

            @Override
            public void onError() {
                progressDialog.dismiss();
                ((BaseActivity)getActivity()).showSnackBar("Login Failed");
            }
        });
    }

    private void restartActivity(){
        Intent i = new Intent(getContext(), MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    private void showProgresDoalog(){
        progressDialog = new ProgressDialog(getActivity(),R.style.transparentProgesDialog);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Large_Inverse);
        progressDialog.show();
    }

}
