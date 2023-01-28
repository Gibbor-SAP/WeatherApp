package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.lang.Short;

public class DetailActivity extends AppCompatActivity {

    //Crear variable para latitud y longitud (float)
    TextView nameOfCity, tempActual, tempMax, tempMin, descripcion;
//    ImageView iconImage;
    float latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//Para obtener la latitud y longitud de la Activity anterior
        Intent myIntent = getIntent();
        latitud = myIntent.getFloatExtra("lat", 0.0f);
        longitud = myIntent.getFloatExtra("long", 0.0f);

//Para obtener las textViews
        nameOfCity = findViewById(R.id.tvCity);
        tempActual = findViewById(R.id.tempActual);
        tempMax = findViewById(R.id.tempMax);
        tempMin = findViewById(R.id.tempMin);
        descripcion = findViewById(R.id.descripcion);
//      iconImage = findViewById(R.id.iconImage);   >> falta crear layout

//       Intent myIntent1 = getIntent();
       String choiceCity = myIntent.getStringExtra("nameCity");
       TextView nameCity = findViewById(R.id.tvCity);
       nameCity.setText(choiceCity);

        obtenerClimaActual();
    }

    private void obtenerClimaActual(){ //Llamar a la API
        Call<Model> call = RetrofitClient.getInstance().getMyApi().getobtenerClimaActual(latitud,longitud,Api.Token,Api.Units,Api.Lang);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()){
                    Model model = response.body();
                    nameOfCity.setText(model.name);
                    tempActual.setText(String.valueOf(model.main.tempAct));
                    tempMax.setText(String.valueOf(model.main.tempMax));
                    tempMin.setText(String.valueOf(model.main.tempMin));

                    Model.Weather weather = model.weather.get(0);
                    descripcion.setText(weather.description);
                }else {
                    Toast.makeText(DetailActivity.this, "Error al intentar conectar.", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Model> call, Throwable t) {
            }
        });
    }

}