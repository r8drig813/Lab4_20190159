package com.example.lab4_20190159.dto;

import java.util.List;

public class GeolocalizacionDto {

    private List<Geolocalizacion> lista;
    private String estado;

    public List<Geolocalizacion> getLista() {
        return lista;
    }

    public void setLista(List<Geolocalizacion> lista) {
        this.lista = lista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
