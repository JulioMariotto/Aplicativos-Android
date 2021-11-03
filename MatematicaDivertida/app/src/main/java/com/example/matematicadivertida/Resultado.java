package com.example.matematicadivertida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView nota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        nota = findViewById(R.id.tv2);
        Intent it = getIntent();
        Bundle params = it.getExtras();
        int acertos = 0;
        acertos = params.getInt("acertos");
        if(it != null) {
            if(acertos == 0){
                nota.setText("1");
            }
            else{
                    nota.setText(String.valueOf(acertos * 20));
            }
        }


    }
}
