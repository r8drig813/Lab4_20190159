package com.example.lab4_20190159.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GeolocalizacionService {
    @GET("/primeNumbers?len=999&order=1")
    Call<List<Number>> getNumber();

}
