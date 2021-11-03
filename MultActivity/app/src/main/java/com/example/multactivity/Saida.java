package com.example.multactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saida extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saida);

        TextView nomeTv, idadeTv, telefoneTv, loginTv, senhaTv;

        nomeTv = (TextView) findViewById(R.id.nomeTv);
        idadeTv = (TextView) findViewById(R.id.idadeTv);
        telefoneTv = (TextView) findViewById(R.id.telefoneTv);
        loginTv = (TextView) findViewById(R.id.loginTv);
        senhaTv = (TextView) findViewById(R.id.senhaTv);

        Intent it = getIntent();

        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){

                nomeTv.setText(params.getString("nome"));
                idadeTv.setText(String.valueOf(params.getInt("idade")));
                telefoneTv.setText(params.getString("telefone"));
                loginTv.setText(params.getString("login"));
                senhaTv.setText(params.getString("senha"));
            }
        }
    }


}
