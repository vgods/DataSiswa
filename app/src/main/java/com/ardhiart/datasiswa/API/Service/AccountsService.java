package com.ardhiart.datasiswa.API.Service;

import com.ardhiart.datasiswa.API.Model.LoginRequest;
import com.ardhiart.datasiswa.API.Model.LoginResponse;
import com.ardhiart.datasiswa.API.Model.NilaiDetail;
import com.ardhiart.datasiswa.API.Model.Siswa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Hinata on 10/16/2017.
 */
public interface AccountsService {
    @POST("Siswas/login")
    Call<LoginResponse> Login(@Body LoginRequest request);

    @GET("Siswas/{id}")
    Call<Siswa> getAccount(@Path("id") String id);

    @GET("Siswas/{id}/nilai/detail")
    Call<List<NilaiDetail>> getNilais(@Path("id") String id);
}
