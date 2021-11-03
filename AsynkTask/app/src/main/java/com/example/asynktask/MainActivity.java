package com.example.asynktask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        bt = findViewById(R.id.button);
    }

    public void processa(View view){
        NumTask num = new NumTask(tv1, bt);
        NumTask num2 = new NumTask(tv2, bt);
        NumTask num3 = new NumTask(tv3, bt);
        num.execute(500);
        num2.execute(100);
        num3.execute(10);
    }
}
