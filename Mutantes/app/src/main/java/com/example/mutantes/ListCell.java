package com.example.mutantes;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListCell extends ArrayAdapter<String> {

    private final Activity context;
    private final List<Mutante> mutantes;
    //private final Integer[] fotos;
    public ListCell(Activity context,  List<Mutante> mutantes) {
        super(context, R.layout.list_cell);
        this.context = context;
        this.mutantes = mutantes;
    }


    @Override
    public View getView(int position, View View, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cell, null, true);
        TextView txt = rowView.findViewById(R.id.nomeMiniatura);
        ImageView img = rowView.findViewById(R.id.fotoMiniatura);
        txt.setText(mutantes.get(position).getNome());
        img.setImageResource(R.drawable.perfil);
        return rowView;
    }
}
