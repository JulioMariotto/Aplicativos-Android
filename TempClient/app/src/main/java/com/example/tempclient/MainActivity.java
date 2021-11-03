package com.example.tempclient;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    TextView tvw;
    ToggleButton tgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.editText);
        tvw = findViewById(R.id.textView);
        tgb = findViewById(R.id.toggleButton);
    }

    public void calc(View view){
        float inputTemp = Float.parseFloat(edt.getText().toString());
        boolean type = tgb.isChecked();
        Conversor objConversor = new Conversor(inputTemp, handler, type);
        objConversor.start();
    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what == 1){
                float tempF = msg.getData().getFloat("resultado");
                tvw.setText(String.format("%.2f ºF", tempF));
            }
            else if(msg.what ==  2){
                float tempF = msg.getData().getFloat("resultado");
                tvw.setText(String.format("%.2f ºC", tempF));
            }
        }
    };
}
