package com.example.lab4_20190159;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lab4_20190159.adapter.ClimaAdapter;
import com.example.lab4_20190159.databinding.FragmentFragmentoClimaBinding;
import com.example.lab4_20190159.dto.Clima;
import com.example.lab4_20190159.service.ClimaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClimaActivity extends AppCompatActivity {

    ClimaService climaService;

    FragmentFragmentoClimaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_fragmento_clima);

        binding = FragmentFragmentoClimaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonNav1.setOnClickListener(v -> {
            Intent intent = new Intent(ClimaActivity.this, GeolocalizacionActivity.class);
            startActivity(intent);
        });

        binding.buttonNav2.setOnClickListener(v -> {
            Intent intent = new Intent(ClimaActivity.this, ClimaActivity.class);
            startActivity(intent);
        });

        climaService = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ClimaService.class);

        Button searchMovie = findViewById(R.id.buttonSearchClima);



        searchMovie.setOnClickListener(v -> {
            EditText editTextLat = findViewById(R.id.editTextSearchLat);
            String Lat = editTextLat.getText().toString();

            EditText editTextLon = findViewById(R.id.editTextSearchLon);
            String Lon = editTextLon.getText().toString();

            climaService.getClima(Double.parseDouble(Lat), Double.parseDouble(Lon),"792edf06f1f5ebcaf43632b55d8b03fe").enqueue(new Callback<Clima>() {
                @Override
                public void onResponse(@NonNull Call<Clima> call, Response<Clima> response) {
                    if(response.isSuccessful()) {
                        Clima clima = response.body();

                        ClimaAdapter climaAdapter = new ClimaAdapter();
                        climaAdapter.setContext(ClimaActivity.this);
                        climaAdapter.setListClima(clima);


                        binding.recyclerView3.setAdapter(climaAdapter);
                        binding.recyclerView3.setLayoutManager(new LinearLayoutManager(ClimaActivity.this));

                    } else {
                        Log.d("msg-test", "error en la respuesta del webservice");
                    }
                }


                @Override
                public void onFailure(Call<Clima> call, Throwable t) {
                    t.printStackTrace();
                }
            });

        });

    }
}