package com.example.weatherapp;

import retrofit2.Retrofit;
import com.google.gson.GsonBuilder;

public class RetrofitClient {
    private static RetrofitClient instance  = null;
    private final Api myApi;

    private RetrofitClient(){
        Retrofit retrofit = new  Retrofit.Builder().baseUrl(Api.Base_URL)
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getMyApi(){
        return myApi;
    }


}
