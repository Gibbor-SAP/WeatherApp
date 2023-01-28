package com.example.weatherapp;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.GsonBuilder;

public interface Api {
    String Base_URL = "https://api.openweathermap.org/data/2.5/"; //insertar url de la base api de opeweather (endpoint)
    String Token = "7f4deca1cbbdd071de70eff35de53a96"; //Token otorgado por la página de openweather
    String Units = "metric"; //Definir las unidades que vienen en los datos (opcional)
    String Lang = "es"; //Definir el idioma (opcional)

    @GET("weather") //Al ser una petición html, se debe colocar el path (weather)
    Call<Model> getobtenerClimaActual(@Query("lat") float latitud, @Query("lon")Float longitud, @Query("appid") String token, @Query("units") String units, @Query("lang")String lenguaje);
}
