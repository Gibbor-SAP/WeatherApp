package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Model {

//Modelo
//Todo lo que va dentro del SeriallizedName tiene que coincidir con las variables del endpoint (archivo json)

    @SerializedName("name")
    public String name;

    @SerializedName("weather")
    public ArrayList<Weather> weather = null;

    @SerializedName("main")
    public Main main = null;

    @SerializedName("visibility")
    public Integer visibility;

    public static class Main {
        @SerializedName("temp")
        public float tempAct;
        @SerializedName("temp_min")
        public float tempMin;
        @SerializedName("temp_max")
        public float tempMax;
    }

    public static class Weather{
        @SerializedName("description")
        public String description;
        @SerializedName("icon")
        public String icon;
    }

    public Model(String name, ArrayList<Weather> weather, Main main, Integer visibility){
        this.name = name;
        this.weather = weather;
        this.main = main;
        this.visibility = visibility;
    }

}
