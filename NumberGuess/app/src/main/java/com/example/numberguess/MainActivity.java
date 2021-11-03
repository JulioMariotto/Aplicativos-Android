package com.example.numberguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int num, tries;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();
        num = r.nextInt(100) + 1;
        tries = 0;
    }

    public void guess(View view){

        EditText input = (EditText) findViewById(R.id.input);
        TextView output = (TextView) findViewById(R.id.hint);

        if(input.length() == 0){
            Toast msg = Toast.makeText(this, "Forneça um número!", Toast.LENGTH_LONG);
            msg.show();
        }
        else{
            String tip;
            int inputNumber = Integer.parseInt(input.getText().toString());
            tries++;
            if(inputNumber < num){
                tip = "Número sorteado é maior.";
            }
            else if(inputNumber > num){
                tip = "Número sorteado é menor.";
            }
            else{
                tip = "Acertou! Você usou "+ tries + " tentativa(s).";
            }
            output.setText(tip);
        }
    }
}
