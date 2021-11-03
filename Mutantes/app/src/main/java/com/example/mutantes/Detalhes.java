package com.example.mutantes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Detalhes extends AppCompatActivity implements Response.ErrorListener, Response.Listener {

    TextView nome, usuario, hb1, hb2, hb3;
    ImageView foto;
    public static final String REQUEST_TAG = "MainVolleyActivity";
    private RequestQueue mQueue;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        nome = findViewById(R.id.tv_nome);
        usuario = findViewById(R.id.tv_usuario);
        hb1 = findViewById(R.id.tv_hb1);
        hb2 = findViewById(R.id.tv_hb2);
        hb3 = findViewById(R.id.tv_hb3);
        foto = findViewById(R.id.imageView);
        foto.setImageResource(R.drawable.perfil);

        Intent it = getIntent();
        int id = it.getIntExtra("id", 10);

        if(id > 0){
            request(id);
        }
    }

    private void request(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mQueue = CustomVolleyRequestQueue.getInstance(this.getApplicationContext()).getRequestQueue();
        String url = "http://172.20.10.5:14076/Android/Detalhe?id=" + id;
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
            if(((JSONObject)response).length() > 0){
                nome.setText(((JSONObject) response).getString("nome"));
                usuario.setText(((JSONObject) response).getString("usuario"));
                hb1.setText(((JSONObject) response).getString("habilidade1"));
                hb2.setText(((JSONObject) response).getString("habilidade2"));
                hb3.setText(((JSONObject) response).getString("habilidade3"));
            }
            System.out.println("Resposta está vazio!");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
