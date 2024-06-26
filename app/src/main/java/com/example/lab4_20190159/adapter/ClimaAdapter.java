package com.example.lab4_20190159.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_20190159.R;
import com.example.lab4_20190159.dto.Clima;
import com.example.lab4_20190159.dto.Geolocalizacion;

import java.util.List;

public class ClimaAdapter extends RecyclerView.Adapter<ClimaAdapter.ClimaViewHolder> {
    private Clima listClima;
    private Context context;

    public Clima getListClima() {
        return listClima;
    }

    public void setListClima(Clima listClima) {
        this.listClima = listClima;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ClimaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.irv_clima, parent, false);
        return new ClimaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClimaViewHolder holder, int position) {

        Clima clima = listClima;
        holder.clima = clima;

        TextView textViewCiudad = holder.itemView.findViewById(R.id.name);
        textViewCiudad.setText(clima.getName());

        TextView textViewMin = holder.itemView.findViewById(R.id.temp_min);
        textViewMin.setText("Min: "+ clima.getMain().getTempMax() + "K");

        TextView textViewMax = holder.itemView.findViewById(R.id.temp_max);
        textViewMax.setText("Max: "+ clima.getMain().getTempMin() + "K");

        TextView textViewTemperatura = holder.itemView.findViewById(R.id.temp);
        textViewTemperatura.setText("Temp: "+ clima.getMain().getTempMin() + "K");

        Log.d("TAG", "Temperatura: " + clima.getMain().getTemp());

    }

    @Override
    public int getItemCount() {
        return listClima != null ? 1 : 0;
    }


    public class ClimaViewHolder extends RecyclerView.ViewHolder{
        Clima clima;
        public ClimaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
