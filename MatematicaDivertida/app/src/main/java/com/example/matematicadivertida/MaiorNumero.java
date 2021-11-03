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

public class MaiorNumero extends AppCompatActivity {

    int contador, resultado, acertos;
    EditText resposta;
    TextView num1, num2, num3;
    AlertDialog alert;
    boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maior_numero);

        num1 = findViewById(R.id.numero1);
        num2 = findViewById(R.id.numero2);
        num3 = findViewById(R.id.numero3);
        resposta = findViewById(R.id.resposta);
        resultado = sorteiaNumeros();
    }

    public void calcula(View view){

        if(resposta.length() != 0) {


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            int certa = Integer.parseInt(resposta.getText().toString());

            if (certa == resultado) {
                builder.setTitle("Acertou!");
                builder.setMessage("Parabens! O maior número possível é " + resultado + ".");
                check = true;
            } else {
                builder.setTitle("Errou!");
                builder.setMessage("A resposta correta do maior número possível é " + resultado + ".");
                check = false;
            }


            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    contador++;
                    if (check) {
                        acertos++;
                    }
                    resultado = sorteiaNumeros();
                    resposta.setText("");
                }
            });

            alert = builder.create();
            alert.show();
        }
    }

    public int sorteiaNumeros(){

        int retorno = 0;
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
            int n1 = random.nextInt(10);
            int n2 = random.nextInt(10);
            int n3 = random.nextInt(10);

            num1.setText(String.valueOf(n1));
            num2.setText(String.valueOf(n2));
            num3.setText(String.valueOf(n3));

            if(n1 >= n2){
                if(n1 >= n3){
                    n1 = n1*100;
                    if(n2 >= n3){
                        n2 = n2*10;
                        retorno = n1 + n2 + n3;
                    }
                    else{
                       n3 = n3*10;
                       retorno = n1 + n3 + n2;
                    }
                }
                else{
                   n3 = n3*100;
                   n1 = n1*10;
                   retorno = n3 + n1 + n2;
                }
            }
            else{

                if(n2 >= n3){
                    n2 = n2*100;

                    if(n1 >= n3){
                        n1 = n1*10;
                        retorno = n2 + n1 + n3;
                    }
                    else{
                        n3 = n3*10;
                        retorno = n2 + n3 + n1;
                    }
                }
                else{
                    n3 = n3*100;
                    n2 = n2*10;
                    retorno = n3 + n2 + n1;
                }
            }
        }

        return retorno;
    }
}
