package com.example.customlist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customlist.R;

public class ListCell extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] refri;
    //private final Integer[] imageId;

    public ListCell(Activity context, String[] refri) {
        super(context, R.layout.list_cell, refri);
        this.context = context;
        this.refri = refri;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cell, null, true);
        TextView txtTitle = rowView.findViewById(R.id.txt);
        txtTitle.setText(refri[position]);
        return rowView;
    }
}
