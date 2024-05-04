package com.example.lab4_20190159.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Main implements Serializable {
    @SerializedName("temp")
    private String temp;
    @SerializedName("feels_like")
    private float feelsLike;
    @SerializedName("temp_min")
    private String  tempMin;
    @SerializedName("temp_max")
    private String tempMax;
    private int pressure;
    private int humidity;
    @SerializedName("sea_level")
    private int seaLevel;
    @SerializedName("grnd_level")
    private int grndLevel;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public int getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(int grndLevel) {
        this.grndLevel = grndLevel;
    }
}
