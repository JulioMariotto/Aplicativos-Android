package com.example.listadecarros;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListCell extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] marcas;
    private final Integer[] fotos;

    public ListCell(Activity context, String[] marcas, Integer[] fotos) {
        super(context, R.layout.list_cell, marcas);
        this.context = context;
        this.marcas = marcas;
        this.fotos = fotos;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cell, null, true);
        TextView txtTitle = rowView.findViewById(R.id.txt);
        ImageView imgView = rowView.findViewById(R.id.img);
        txtTitle.setText(marcas[position]);
        imgView.setImageResource(fotos[position]);
        return rowView;
    }
}
