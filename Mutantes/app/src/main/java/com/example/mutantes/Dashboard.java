package com.example.mutantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void novoMutante(View view){
        Intent it = new Intent(this, Novo.class);
        startActivity(it);
    }

    public void listarMutantes(View view){
        Intent it = new Intent(this, Lista.class);
        startActivity(it);
    }

    public void pesquisarMutantes(View view){

    }

    public void sair(View view){
        finish();
        System.exit(0);
    }

}
