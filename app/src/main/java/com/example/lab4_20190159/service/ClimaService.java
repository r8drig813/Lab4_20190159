package com.example.lab4_20190159.service;

import com.example.lab4_20190159.dto.Clima;
import com.example.lab4_20190159.dto.Geolocalizacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClimaService {

    @GET("/data/2.5/weather")
    Call<Clima> getClima(@Query("lat") double lat, @Query("lon") double lon, @Query("appid") String api);
}
