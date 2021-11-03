package com.example.customlist;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int idItem;
    ListView list;
    EditText qtd;
    String[] refri = { "BBDC3", "BRDT3"};
    Integer[] imageID = { R.drawable.coca, R.drawable.fanta};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qtd = findViewById(R.id.editText);
        ListCell adapter = new ListCell(MainActivity.this, refri);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.idItem = position;
                Toast.makeText(MainActivity.this, "222", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void process(View view){

        int quantidade = Integer.parseInt(qtd.getText().toString());
        String codigo = refri[MainActivity.idItem];

    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what == 1){
                float tempF = msg.getData().getFloat("resultado");
                //tvw.setText(String.format("%.2f ºF", tempF));
            }
            else if(msg.what ==  2){
                float tempF = msg.getData().getFloat("resultado");
                //tvw.setText(String.format("%.2f ºC", tempF));
            }
        }
    };
}
