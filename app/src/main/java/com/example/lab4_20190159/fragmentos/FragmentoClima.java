package com.example.lab4_20190159.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab4_20190159.R;
import com.example.lab4_20190159.databinding.FragmentFragmentoClimaBinding;
import com.example.lab4_20190159.service.ClimaService;

import java.util.concurrent.ExecutorService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentoClima extends Fragment {
    FragmentFragmentoClimaBinding binding;

    ClimaService climaService;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFragmentoClimaBinding.inflate(inflater, container, false);

        binding.buttonNav1.setOnClickListener(view -> {

            NavController navController = NavHostFragment.findNavController(FragmentoClima.this);
            navController.navigate(R.id.action_fragmentoClima_to_fragmentoGeolocalizacion);
        });

        binding.buttonNav2.setOnClickListener(view -> {
            NavController navController = NavHostFragment.findNavController(FragmentoClima.this);
            navController.navigate(R.id.fragmentoClima);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentFragmentoClimaBinding.inflate(getLayoutInflater());


        climaService = new Retrofit.Builder()
                .baseUrl("https://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ClimaService.class);

    }
}