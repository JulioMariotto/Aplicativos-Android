package com.example.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcula(View view){

        EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        EditText pesoEditText = (EditText) findViewById(R.id.pesoEditText);
        EditText alturaEditText = (EditText) findViewById(R.id.alturaEditText);

        if(nomeEditText.length() != 0 && alturaEditText.length() != 0 && pesoEditText.length() != 0){

            float altura, peso, resultado;
            String nome;

            nome = nomeEditText.getText().toString();
            altura = Float.parseFloat(alturaEditText.getText().toString());
            peso = Float.parseFloat(pesoEditText.getText().toString());
            resultado = peso / (altura*altura);

            Intent it = new Intent(this, Tela2.class);
            Bundle params = new Bundle();
            params.putString("nome", nome);
            params.putFloat("resultado", resultado);
            it.putExtras(params);
            startActivity(it);

        }
        else{
            Toast.makeText(this, "Insira todos os dados!", Toast.LENGTH_LONG).show();
        }
    }
}
