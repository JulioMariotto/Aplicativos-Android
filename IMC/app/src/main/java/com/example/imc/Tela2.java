package com.example.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        TextView nomeTv = (TextView) findViewById(R.id.nomeTv);
        TextView imcTv = (TextView) findViewById(R.id.imcTv);
        TextView msgTV = (TextView) findViewById(R.id.msgTv);

        Intent it = getIntent();
        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String nome = params.getString("nome");
                float resultado = params.getFloat("resultado");
                nomeTv.setText(nome);
                imcTv.setText(String.format("%.2f", resultado));
                if(resultado < 15){
                    msgTV.setText("Extremamente abaixo do peso");
                }
                else if(resultado < 16){
                    msgTV.setText("Gravemente abaixo do peso");
                }
                else if(resultado < 18.5){
                    msgTV.setText("Abaixo do peso ideal");
                }
                else if(resultado < 25){
                    msgTV.setText("Faixa de peso ideal");
                }
                else if(resultado < 30){
                    msgTV.setText("Sobrepeso");
                }
                else if(resultado < 35){
                    msgTV.setText("Obseidade grau I");
                }
                else if(resultado < 40){
                    msgTV.setText("Obesidade grau II (grave)");
                }
                else{
                    msgTV.setText("Obesidade grau III (mórbida)");
                }
            }
        }
    }
}
