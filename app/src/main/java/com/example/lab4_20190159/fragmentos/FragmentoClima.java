package com.example.lab4_20190159.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab4_20190159.R;
import com.example.lab4_20190159.databinding.FragmentFragmentoClimaBinding;


public class FragmentoClima extends Fragment {
    FragmentFragmentoClimaBinding binding;


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
}