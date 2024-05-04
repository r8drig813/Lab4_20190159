package com.example.lab4_20190159.service;

import com.example.lab4_20190159.dto.Geolocalizacion;
import com.example.lab4_20190159.dto.GeolocalizacionDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeolocalizacionService {
    @GET("/geo/1.0/direct")
    Call<GeolocalizacionDto> getGeolocalizacion(@Query("q") String city, @Query("limit") int one, @Query("appid") String api);

}
