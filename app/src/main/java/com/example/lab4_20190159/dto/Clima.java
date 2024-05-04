package com.example.lab4_20190159.dto;

import java.io.Serializable;

public class Clima implements Serializable {


    private Main main;
    private String name;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
