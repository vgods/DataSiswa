package com.ardhiart.datasiswa.API.Service;

import com.ardhiart.datasiswa.API.Model.Mapel;
import com.ardhiart.datasiswa.API.Model.TugasMapel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Hinata on 10/16/2017.
 */
public interface NilaiService {

    @GET("Nilais/{mapelId}/{siswaId}")
    Call<List<TugasMapel>> getNilaiBySiswaMapel(@Path("mapelId") String mapelId, @Path("siswaId") String siswaId);

}
