package com.example.lab4_20190159.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab4_20190159.R;
import com.example.lab4_20190159.databinding.FragmentFragmentoGeolocalizacionBinding;

public class FragmentoGeolocalizacion extends Fragment {

    FragmentFragmentoGeolocalizacionBinding binding;

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

        return binding.getRoot();
    }
}