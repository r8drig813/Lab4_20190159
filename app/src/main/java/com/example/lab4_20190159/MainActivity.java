package com.example.lab4_20190159;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab4_20190159.databinding.ActivityMainBinding;
import com.example.lab4_20190159.databinding.FragmentFragmentoClimaBinding;
import com.example.lab4_20190159.fragmentos.FragmentoClima;
import com.example.lab4_20190159.fragmentos.FragmentoGeolocalizacion;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button primeButton = findViewById(R.id.button);

        primeButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Navigation_Activity.class);
            startActivity(intent);
        });


    }
}