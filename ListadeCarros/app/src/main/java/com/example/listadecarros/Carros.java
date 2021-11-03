package com.example.listadecarros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Carros extends AppCompatActivity {

    ListView list;
    String[][] carros = {
            {"Prisma", "Onix"},
            {"Argo", "Toro"},
            {"Civic", "City"},
            {"Jetta", "Golf"}
    };
    String[] selCarros;
    String[][] valores = {
            {"R$45.000,00", "R$39.000,00"},
            {"R$55.000,00", "R$125.000,00"},
            {"R$118.000,00", "R$75.000,00"},
            {"R$114.000,00", "R$144.000,00"}
    };
    String[] selValores;
    Integer[][] fotos = {
            {R.drawable.prisma, R.drawable.onix},
            {R.drawable.argo, R.drawable.toro},
            {R.drawable.civic, R.drawable.city},
            {R.drawable.jetta, R.drawable.golf}
    };
    Integer[] selFotos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);

        Intent it = getIntent();

        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                selCarros = carros[params.getInt("position")];
                selFotos = fotos[params.getInt("position")];
                selValores = valores[params.getInt("position")];
                ListCell adapter = new ListCell(Carros.this, selCarros, selFotos);
                list = (ListView) findViewById(R.id.list);
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent it = new Intent(Carros.this, Detalhes.class);
                        Bundle params =new Bundle();

                        params.putString("carro", selCarros[position]);
                        params.putInt("foto", selFotos[position]);
                        params.putString("valor", selValores[position]);

                        it.putExtras(params);
                        startActivity(it);
                    }
                });

            }
        }
    }

    public void desliga(View view){
        finish();
    }
}
