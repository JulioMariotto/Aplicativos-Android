package com.example.matematicadivertida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jogoContagem(View view){
        Intent it = new Intent(this, Contagem.class);
        startActivity(it);
    }

    public void jogoAritmetica(View view){
        Intent it = new Intent(this, AritmeticaBasica.class);
        startActivity(it);
    }

    public void jogoMaiorNumero(View view){
        Intent it = new Intent(this, MaiorNumero.class);
        startActivity(it);
    }

}
