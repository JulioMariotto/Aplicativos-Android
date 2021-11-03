package com.example.listadecarros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] marcas = {"Chevrolet", "Fiat", "Honda", "Volkswagen"};
    Integer[] fotos = {R.drawable.chev, R.drawable.fiat, R.drawable.honda, R.drawable.volks};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListCell adapter = new ListCell(MainActivity.this, marcas, fotos);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent it = new Intent(MainActivity.this, Carros.class);
                Bundle params =new Bundle();

                params.putInt("position", position);
                params.putLong("id", id);

                it.putExtras(params);
                startActivity(it);
            }
        });
    }
}
