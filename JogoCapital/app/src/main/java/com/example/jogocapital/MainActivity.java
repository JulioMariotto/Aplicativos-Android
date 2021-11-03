package com.example.jogocapital;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[][] capitais = {{"Paraná", "São Paulo", "Rio de Janeiro", "Minas Gerais", "Rio Grande do Sul"}, {"Curitiba", "Sao Paulo", "Rio de Janeiro", "Belo Horizonte", "Porto Alegre"}};
    Random r;
    int num, atual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atual = 0;
        r = new Random();
        sort();
    }

    public void sort(){
        TextView output = (TextView) findViewById(R.id.question);
        atual = r.nextInt(4);
        output.setText(capitais[0][atual]);
    }

    public void tentativa(View view){
        EditText input = (EditText) findViewById(R.id.input);
        TextView output = (TextView) findViewById(R.id.output);
        String tentativa = input.getText().toString();
        if(tentativa.isEmpty()){
            Toast msg = Toast.makeText(this, "Preencha o campo texto!", Toast.LENGTH_LONG);
            msg.show();
        }
        else {
            if(tentativa.equalsIgnoreCase(capitais[1][atual])){
                output.setText("Acertou!");
                input.setText("");
                sort();
            }
            else {
                output.setText("Errou!");
            }
        }
    }
}
