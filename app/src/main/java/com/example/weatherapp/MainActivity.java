package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //Mensaje emergente con la clase Toast
        Toast.makeText(this, "Bienvenido a la aplicación del Clima", Toast.LENGTH_SHORT).show();
    }

    //Metodos para pasar de una Activity a otra

    public void cityList (View view) {
        Intent myIntent = new Intent(this, ListActivity.class);
        startActivity(myIntent);

    }

    public void irAlDetalle(View view) {
    //Inicio una nueva Activity
        Intent myIntent = new Intent(this, DetailActivity.class);
//        myIntent.putExtra("nameCity", "Formosa "); Se puede hardcodear la ciudad

    //Le tengo que pasar la Latitud y Longitud de una ciudad (estaría hardcodeado)
        myIntent.putExtra("lat", -26.18489f); //latitud de la iudad (finaliza con f de float)
        myIntent.putExtra("long", -58.17313f); //lontitud de la ciudad (finaliza con f de float)
        startActivity(myIntent);
    }
}