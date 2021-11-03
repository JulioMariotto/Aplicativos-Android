package com.example.downloadtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void download(View view){

        et = findViewById(R.id.editText);
        bt = findViewById(R.id.button);
        img = findViewById(R.id.imageView);
        DownloadTaks run = new DownloadTaks(img, this);
        run.execute(et.getText().toString());
    }

}
