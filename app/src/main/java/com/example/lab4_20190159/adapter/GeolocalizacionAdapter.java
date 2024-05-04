package com.example.lab4_20190159.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_20190159.R;
import com.example.lab4_20190159.dto.Geolocalizacion;

import java.util.List;

public class GeolocalizacionAdapter extends RecyclerView.Adapter<GeolocalizacionAdapter.GeolocalizacionViewHolder> {

    private List<Geolocalizacion> listGeolocalizacion;
    private Context context;


    public List<Geolocalizacion> getListGeolocalizacion() {
        return listGeolocalizacion;
    }

    public void setListGeolocalizacion(List<Geolocalizacion> listGeolocalizacion) {
        this.listGeolocalizacion = listGeolocalizacion;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GeolocalizacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.irv_geolocalizacion, parent, false);
        return new GeolocalizacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GeolocalizacionViewHolder holder, int position) {

        Geolocalizacion geo = listGeolocalizacion.get(position);
        holder.geolocalizacion = geo;

        TextView textViewCiudad = holder.itemView.findViewById(R.id.ciudad);
        textViewCiudad.setText("Ciudad" + geo.getName());

        TextView textViewLatitud = holder.itemView.findViewById(R.id.latitud);
        textViewLatitud.setText("Lat: "+ geo.getLat());

        TextView textViewLongitud = holder.itemView.findViewById(R.id.longitud);
        textViewLongitud.setText("Lon: "+ geo.getLon());

    }

    @Override
    public int getItemCount() {
        return listGeolocalizacion.size();
    }


    public class GeolocalizacionViewHolder extends RecyclerView.ViewHolder{
        Geolocalizacion geolocalizacion;
        public GeolocalizacionViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
