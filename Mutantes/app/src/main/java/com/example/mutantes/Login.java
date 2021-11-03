package com.example.mutantes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Login extends AppCompatActivity implements Response.Listener, Response.ErrorListener{

    public static final String REQUEST_TAG = "MainVolleyActivity";
    private Button button;
    private EditText login, senha;
    private RequestQueue mQueue;
    AlertDialog alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.button);
        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);

    }

    @Override
    protected void onStop() {
        super.onStop();

        if(mQueue != null){
            mQueue.cancelAll(REQUEST_TAG);
        }
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
            String resposta = ((JSONObject) response).getString("resposta");
            if(resposta.equals("true")){
                Intent it = new Intent(this, Dashboard.class);
                startActivity(it);
                finish();
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Erro!");
                builder.setMessage("Login ou senha incorretos.");
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        login.setText("");
                        senha.setText("");
                    }
                });

                alert = builder.create();
                alert.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        button.setVisibility(View.VISIBLE);
    }

    public void autenticar(View view){
        button.setVisibility(View.INVISIBLE);
        mQueue = CustomVolleyRequestQueue.getInstance(this.getApplicationContext()).getRequestQueue();
        //String url = "http://localhost:14076/Android/webresources/usuario?nome" + login.getText().toString() + "&senha=" + senha.getText().toString();
        String url = "http://172.20.10.5:14076/Android/Autenticar?nome=" + login.getText().toString() + "&senha=" + senha.getText().toString();
        final CustomJSONObjectRequest jsonRequest = new CustomJSONObjectRequest(Request.Method.GET, url, new JSONObject(), this, this);
        jsonRequest.setTag(REQUEST_TAG);
        mQueue.add(jsonRequest);
    }
}
