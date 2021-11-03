package com.example.multactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Entrada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
    }

    public void enviar(View view){
        EditText nomeEt, idadeEt, telefoneEt, loginEt, senhaEt;
        nomeEt = (EditText) findViewById(R.id.nomeEt);
        idadeEt = (EditText) findViewById(R.id.idadeEt);
        telefoneEt = (EditText) findViewById(R.id.telefoneEt);
        loginEt = (EditText) findViewById(R.id.loginEt);
        senhaEt = (EditText) findViewById(R.id.senhaEt);

        if(nomeEt.length() != 0 && idadeEt.length() != 0 && telefoneEt.length() != 0 && loginEt.length() != 0 && senhaEt.length() != 0){
            String nome, telefone, login, senha;
            int idade;
            nome = nomeEt.getText().toString();
            idade = Integer.parseInt(idadeEt.getText().toString());
            telefone = telefoneEt.getText().toString();
            login = loginEt.getText().toString();
            senha = senhaEt.getText().toString();

            Intent it = new Intent(this, Saida.class);
            Bundle params = new Bundle();

            params.putString("nome", nome);
            params.putInt("idade", idade);
            params.putString("telefone", telefone);
            params.putString("login", login);
            params.putString("senha", senha);

            it.putExtras(params);

            startActivity(it);

        }
        else{
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
        }
    }
}
