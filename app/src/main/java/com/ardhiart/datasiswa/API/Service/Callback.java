package com.ardhiart.datasiswa.API.Service;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hinata on 10/16/2017.
 */
public abstract class Callback<T> implements retrofit2.Callback<T> {
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError();
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        //TODO: Check if response contains error
        if (response.isSuccessful()) {
            onSucces(call, response);
        } else {
            onError();
        }
    }

    public abstract void onSucces(Call<T> call, Response<T> response);
    public abstract void onError();

}
