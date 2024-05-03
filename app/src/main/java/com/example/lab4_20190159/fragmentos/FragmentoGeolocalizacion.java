package com.example.lab4_20190159.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.lab4_20190159.R;
import com.example.lab4_20190159.databinding.FragmentFragmentoClimaBinding;
import com.example.lab4_20190159.databinding.FragmentFragmentoGeolocalizacionBinding;
import com.example.lab4_20190159.service.GeolocalizacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentoGeolocalizacion extends Fragment {

    FragmentFragmentoGeolocalizacionBinding binding;

    GeolocalizacionService geolocalizacionService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFragmentoGeolocalizacionBinding.inflate(inflater, container, false);

        binding.buttonNav1.setOnClickListener(view -> {

            NavController navController = NavHostFragment.findNavController(FragmentoGeolocalizacion.this);
            navController.navigate(R.id.fragmentoGeolocalizacion);
        });

        binding.buttonNav2.setOnClickListener(view -> {

            NavController navController = NavHostFragment.findNavController(FragmentoGeolocalizacion.this);
            navController.navigate(R.id.action_fragmentoGeolocalizacion_to_fragmentoClima);
        });

        geolocalizacionService = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/geo/1.0")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GeolocalizacionService.class);

        return binding.getRoot();
    }


}