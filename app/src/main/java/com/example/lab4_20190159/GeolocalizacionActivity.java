package com.example.lab4_20190159;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lab4_20190159.adapter.GeolocalizacionAdapter;
import com.example.lab4_20190159.databinding.FragmentFragmentoGeolocalizacionBinding;
import com.example.lab4_20190159.dto.Geolocalizacion;
import com.example.lab4_20190159.dto.GeolocalizacionDto;
import com.example.lab4_20190159.fragmentos.FragmentoClima;
import com.example.lab4_20190159.service.GeolocalizacionService;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeolocalizacionActivity extends AppCompatActivity {

    GeolocalizacionService geolocalizacionService;

    FragmentFragmentoGeolocalizacionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_fragmento_geolocalizacion);

        binding = FragmentFragmentoGeolocalizacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.buttonNav1.setOnClickListener(v -> {
            Intent intent = new Intent(GeolocalizacionActivity.this, GeolocalizacionActivity.class);
            startActivity(intent);
        });

        binding.buttonNav2.setOnClickListener(v -> {
            Intent intent = new Intent(GeolocalizacionActivity.this, ClimaActivity.class);
            startActivity(intent);
        });



        geolocalizacionService = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GeolocalizacionService.class);

        Button searchMovie = findViewById(R.id.buttonSearchGeo);



        searchMovie.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.editTextSearchGeo);
            String city = editText.getText().toString();

            geolocalizacionService.getGeolocalizacion(city,1,"8dd6fc3be19ceb8601c2c3e811c16cf1").enqueue(new Callback<List<Geolocalizacion>>() {
                @Override
                public void onResponse(@NonNull Call<List<Geolocalizacion>> call, Response<List<Geolocalizacion>> response) {
                    if(response.isSuccessful()) {
                        List<Geolocalizacion> geolocalizacions = response.body();

                        GeolocalizacionAdapter geolocalizacionAdapter = new GeolocalizacionAdapter();
                        geolocalizacionAdapter.setContext(GeolocalizacionActivity.this);
                        geolocalizacionAdapter.setListGeolocalizacion(geolocalizacions);


                        binding.recyclerView.setAdapter(geolocalizacionAdapter);
                        binding.recyclerView.setLayoutManager(new LinearLayoutManager(GeolocalizacionActivity.this));

                    } else {
                        Log.d("msg-test", "error en la respuesta del webservice");
                    }
                }


                @Override
                public void onFailure(Call<List<Geolocalizacion>> call, Throwable t) {
                    t.printStackTrace();
                }
            });

        });

    }
}