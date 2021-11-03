package com.example.listadecarros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalhes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        TextView nomeCarro, valorCarro;
        ImageView fotoCarro;

        nomeCarro =  findViewById(R.id.nomeCarro);
        valorCarro = findViewById(R.id.valorCarro);
        fotoCarro =  findViewById(R.id.fotoCarro);

        Intent it = getIntent();

        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){

                nomeCarro.setText(params.getString("carro"));
                valorCarro.setText(params.getString("valor"));
                fotoCarro.setImageResource(params.getInt("foto"));

            }
        }
    }
}
