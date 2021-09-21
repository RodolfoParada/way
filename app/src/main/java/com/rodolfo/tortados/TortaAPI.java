package com.rodolfo.tortados;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface TortaAPI {

    @GET
    public Call<List<Torta>> getTorta(@Url String url);

    @GET
    public Call<TortaDetalle> getTortaDetalle(@Url String url);
}


