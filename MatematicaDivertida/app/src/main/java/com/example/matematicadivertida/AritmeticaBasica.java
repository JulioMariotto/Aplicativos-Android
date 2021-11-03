package com.example.matematicadivertida;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class AritmeticaBasica extends AppCompatActivity {

    int contador, resultado, acertos;
    EditText resposta;
    TextView equacao;
    AlertDialog alert;
    boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica_basica);

        equacao = findViewById(R.id.equacao);
        resposta = findViewById(R.id.resposta);

        geraConta();
    }

    public void calcula(View view){

        if(resposta.length() != 0) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            int certa = Integer.parseInt(resposta.getText().toString());

            if (certa == resultado) {
                builder.setTitle("Acertou!");
                builder.setMessage("Parabens! " + equacao.getText().toString() + " = " + resultado + ".");
                check = true;
            } else {
                builder.setTitle("Errou!");
                builder.setMessage("A resposta correta é " + equacao.getText().toString() + " = " + resultado + ".");
                check = false;
            }


            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    contador++;
                    if (check) {
                        acertos++;
                    }
                    geraConta();
                }
            });

            alert = builder.create();
            alert.show();
        }
    }

    public void geraConta(){

        if(contador > 4){
            Intent it = new Intent(this, Resultado.class);
            Bundle params = new Bundle();
            params.putInt("acertos", acertos);
            it.putExtras(params);
            startActivity(it);
            finish();
        }
        else {
            Random random = new Random();
            int op1 = random.nextInt(10);
            int operador = random.nextInt(10);
            int op2 = random.nextInt(10);
            if(operador < 5){
                resultado = op1 + op2;
                equacao.setText(String.valueOf(op1 + " + " + op2));
                resposta.setText("");
            }
            else{
                resultado = op1 - op2;
                equacao.setText(String.valueOf(op1 + " - " + op2));
                resposta.setText("");
            }
        }
    }
}
