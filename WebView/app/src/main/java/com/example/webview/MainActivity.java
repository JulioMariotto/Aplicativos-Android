package com.example.webview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView web;
    private ProgressBar pgb;
    private ImageButton back, forward, reload;
    private String[] URL = {"http://www.google.com"};
    private int indice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.webView);
        pgb = findViewById(R.id.progressBar);
        pgb.setVisibility(View.INVISIBLE);
        back = findViewById(R.id.btnVoltar);
        forward = findViewById(R.id.btnAvancar);
        reload = findViewById(R.id.btnRecarrega);
        back.setClickable(false);
        forward.setClickable(false);
        load(URL[0]);

    }

    public void go(View view){

        EditText edt = findViewById(R.id.editText);
        String newURL = edt.getText().toString();
        indice++;
        URL.;
        load(URL[indice]);
    }

    public void reload(View view){
        load(URL[indice]);
    }

    public void back(View view){
        if(indice > 0){
            indice--;
            load(URL[indice]);
            forward.setClickable(true);
        }
        else{
            back.setClickable(false);
        }

    }

    public void forward(View view){

        if(URL.length > indice){
            indice ++;
            load(URL[indice]);
            back.setClickable(true);
        }
        else{
            forward.setClickable(false);
        }
    }

    private void load(String newURL){

        web.loadUrl(newURL);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pgb.setVisibility(View.VISIBLE);
                pgb.setProgress(10);
                try {
                    Thread.sleep(150);
                    pgb.setProgress(50);
                    Thread.sleep(150);
                    pgb.setProgress(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pgb.setProgress(100);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pgb.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        });

    }
}
