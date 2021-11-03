package com.example.mutantes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Novo extends AppCompatActivity implements Response.Listener, Response.ErrorListener{

    private EditText nome, usuario, hb1, hb2, hb3;
    public static final String REQUEST_TAG = "MainVolleyActivity";
    private RequestQueue mQueue;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        nome = findViewById(R.id.et_nome);
        usuario = findViewById(R.id.et_usuario);
        hb1 = findViewById(R.id.et_hb1);
        hb2 = findViewById(R.id.et_hb2);
        hb3 = findViewById(R.id.et_hb3);
    }

    public void criarMutante(View view){

        String nomeM, usuarioM, hb1M, hb2M, hb3M;
        nomeM = nome.getText().toString();
        usuarioM = usuario.getText().toString();
        hb1M = hb1.getText().toString();
        hb2M = hb2.getText().toString();
        hb3M = hb3.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mQueue = CustomVolleyRequestQueue.getInstance(this.getApplicationContext()).getRequestQueue();
        if(nomeM.isEmpty()){

            builder.setTitle("Erro!");
            builder.setMessage("Preencha o campo nome");
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alert = builder.create();
            alert.show();
            nome.requestFocus();
            return;
        }
        if(usuarioM.isEmpty()){

            builder.setTitle("Erro!");
            builder.setMessage("Preencha o campo usuario");
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alert = builder.create();
            alert.show();
            usuario.requestFocus();
            return;
        }
        if(hb1M.isEmpty()){

            builder.setTitle("Erro!");
            builder.setMessage("Preencha pelo menos 1 habilidade");
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alert = builder.create();
            alert.show();
            hb1.requestFocus();
            return;
        }
        if(hb2M.isEmpty()){

            hb2M = "";
        }
        if(hb3M.isEmpty()){

            hb3M = "";
        }

        String url = "http://172.20.10.5:14076/Android/Novo?nome=" + nomeM + "&usuario=" + usuarioM + "&hb1=" + hb1M + "&hb2=" + hb2M + "&hb3=" + hb3M;
        final CustomJSONObjectRequest jsonRequest = new CustomJSONObjectRequest(Request.Method.GET, url, new JSONObject(), this, this);
        jsonRequest.setTag(REQUEST_TAG);
        mQueue.add(jsonRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Erro!");
        builder.setMessage("Erro de conexão");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert = builder.create();
        alert.show();
    }

    @Override
    public void onResponse(Object response) {

        try {
            int resposta = ((JSONObject) response).getInt("resposta");
            if(resposta >  0){
                Intent it = new Intent(this, Detalhes.class);
                it.putExtra("id", resposta);
                startActivity(it);
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Erro!");
                builder.setMessage("Ja há um mutante com este nome!.");
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alert = builder.create();
                alert.show();
                nome.requestFocus();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        if(mQueue != null){
            mQueue.cancelAll(REQUEST_TAG);
        }
    }
}
