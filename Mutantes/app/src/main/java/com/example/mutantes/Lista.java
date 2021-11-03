package com.example.mutantes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity implements Response.Listener, Response.ErrorListener{

    ListView list;
    List<Mutante> mutantes;
    public static final String REQUEST_TAG = "MainVolleyActivity";
    private RequestQueue mQueue;
    AlertDialog alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        carregaLista();
        ListCell adapter = new ListCell(Lista.this, mutantes);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(Lista.this, Detalhes.class);
                it.putExtra("id", mutantes.get(position).getId());
                startActivity(it);
            }
        });
    }

    private void carregaLista() {

        mQueue = CustomVolleyRequestQueue.getInstance(this.getApplicationContext()).getRequestQueue();
        String url = "http://172.20.10.5:14076/Android/Lista";
        final CustomJSONObjectRequest jsonRequest = new CustomJSONObjectRequest(Request.Method.GET, url, new JSONObject(), this, this);
        jsonRequest.setTag(REQUEST_TAG);
        mQueue.add(jsonRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Erro!");
        builder.setMessage(error.getMessage());
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
            List<Mutante> list = new ArrayList();
            JSONArray json = new JSONArray(response);
            for(int i = 0; i > json.length(); i++){
                list.add(new Mutante(json.getJSONObject(i).getInt("id"), json.getJSONObject(i).getString("nome"), json.getJSONObject(i).getString("usuario"), json.getJSONObject(i).getString("habilidade1"), json.getJSONObject(i).getString("habilidade2"), json.getJSONObject(i).getString("habilidade3")));
            }
            mutantes = list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
