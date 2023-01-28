package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    //private int layout;
    private ArrayList<String> citys;

    public CustomAdapter(Context context, ArrayList<String> citys){
        this.context = context;
        this.citys = citys;
    }

    @Override
    public int getCount() {
        return citys.size();
    }

    @Override
    public Object getItem(int position) {
        return this.citys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        //Se infla la vista con el layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        view = layoutInflater.inflate(R.layout.list_item_citys, null);

        //Valor actual según la posición
        String currentName = citys.get(position);

        //Referenciar el elemento a modificar y rellenar
        TextView textView = (TextView) view.findViewById(R.id.textView_itemCity);
        textView.setText(currentName);

        //Se devuelve la vista inflada
        return view;
    }
}
