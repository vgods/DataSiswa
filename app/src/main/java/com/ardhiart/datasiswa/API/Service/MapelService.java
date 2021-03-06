package com.ardhiart.datasiswa.API.Service;

import com.ardhiart.datasiswa.API.Model.Mapel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Hinata on 10/16/2017.
 */
public interface MapelService {

    @GET("Mapels")
    Call<List<Mapel>> getAllMapel();

    @GET("Mapels/{id}")
    Call<Mapel> getMapel(@Path("id") String id);
}
