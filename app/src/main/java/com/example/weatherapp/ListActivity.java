package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> citys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setupListView();
    }

    void setupListView(){
        listView = (ListView) findViewById(R.id.listView);

        citys = new ArrayList<String>();

        citys.add("Buenos Aires");
        citys.add("Rosario");
        citys.add("Formosa");
        citys.add("Salta");
        citys.add("Jujuy");

       // ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, citys);
       // listView.setAdapter(arrayAdapter);

        CustomAdapter adapter = new CustomAdapter(this, citys);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToDetail(citys.get(position));
            }
        });

    }

    private void goToDetail(String city){
        Intent myIntent = new Intent(this, DetailActivity.class);
        myIntent.putExtra("nameCity", city);
        startActivity(myIntent);

    }

}