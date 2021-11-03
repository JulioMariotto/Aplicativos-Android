package com.example.matematicadivertida;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Contagem extends AppCompatActivity {

    ImageView img;
    TextView perg;
    Button bt1, bt2, bt3;
    Pergunta pgt;
    List<Pergunta> list;
    AlertDialog alert;
    int resposta, acertos;
    boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contagem);

        acertos = 0;
        list = carregaPerguntas();
        list = selecionaPerguntas(list);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        img = findViewById(R.id.imageView);
        perg = findViewById(R.id.pergunta);
        mudaView(list);
    }

    private List<Pergunta> carregaPerguntas() {

        List<Pergunta> list = new ArrayList();

        String um[] = {"3", "1", "2"};
        Pergunta p = new Pergunta(0, "Quantos quadrados tem a imagem acima?" , um, 1, R.drawable.um);
        list.add(p);

        String dois[] = {"3", "2", "1"};
        p = new Pergunta(1, "Quantos triângulos tem a imagem acima?" , dois, 2, R.drawable.dois);
        list.add(p);

        String tres[] = {"2", "5", "3"};
        p = new Pergunta(2, "Quantos circulos tem a imagem acima?" , tres, 3, R.drawable.tres);
        list.add(p);

        String quatro[] = {"4", "3", "2"};
        p = new Pergunta(3, "Quantas barras tem a imagem acima?" , quatro, 4, R.drawable.quatro);
        list.add(p);

        String cinco[] = {"3", "5", "6"};
        p = new Pergunta(4, "Quantos losangos tem a imagem acima?" , cinco, 5, R.drawable.cinco);
        list.add(p);

        String seis[] = {"5", "7", "6"};
        p = new Pergunta(5, "Quantas estrelas tem a imagem acima?" , seis, 6, R.drawable.seis);
        list.add(p);

        String sete[] = {"8", "6", "7"};
        p = new Pergunta(6, "Quantos pentágonos tem a imagem acima?" , sete, 7, R.drawable.sete);
        list.add(p);

        String oito[] = {"7", "8", "6"};
        p = new Pergunta(7, "Quantas setas tem a imagem acima?" , oito, 8, R.drawable.oito);
        list.add(p);

        String nove[] = {"7", "10", "9"};
        p = new Pergunta(8, "Quantos circulos tem a imagem acima?" , nove, 9, R.drawable.nove);
        list.add(p);

        String dez[] = {"10", "9", "11"};
        p = new Pergunta(9, "Quantos quadrados tem a imagem acima?" , dez, 10, R.drawable.dez);
        list.add(p);

        return list;
    }

    public void resposta(View view){

        Button bt = findViewById(view.getId());
        int certa = Integer.parseInt(bt.getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(certa == resposta){
            builder.setTitle("Acertou!");
            builder.setMessage("Parabens! A imagem tem " + resposta + " figura(s).");
            check = true;
        }
        else
        {
            builder.setTitle("Errou!");
            builder.setMessage("A resposta correta é " + resposta + " figura(s).");
            check = false;
        }


        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(check){
                    acertos++;
                }
                mudaView(list);
            }
        });

        alert = builder.create();
        alert.show();

    }

    public void mudaView(List<Pergunta> list){

        if(!list.isEmpty()){

            pgt = list.get(0);
            bt1.setText(pgt.getRespostas()[0]);
            bt2.setText(pgt.getRespostas()[1]);
            bt3.setText(pgt.getRespostas()[2]);
            img.setImageResource(pgt.getIdFoto());
            perg.setText(pgt.getPergunta());
            resposta = pgt.getCerta();
            list.remove(0);
        }
        else{
            Intent it = new Intent(this, Resultado.class);
            Bundle params = new Bundle();
            params.putInt("acertos", acertos);
            it.putExtras(params);
            startActivity(it);
            finish();
        }

    }

    public List<Pergunta> selecionaPerguntas(List<Pergunta> list){

        int num1, num2, num3, num4, num5;

        List<Pergunta> aux = new ArrayList();
        Random random = new Random();
        num1 = random.nextInt(9);

        num2 = random.nextInt(9);
        while (num2 == num1){
            num2 = random.nextInt(9);
        }

        num3 = random.nextInt(9);
        while (num3 == num1 || num3 == num2){
            num3 = random.nextInt(9);
        }

        num4 = random.nextInt(9);
        while (num4 == num1 || num4 == num2 || num4 == num3){
            num4 = random.nextInt(9);
        }

        num5 = random.nextInt(9);
        while (num5 == num1 || num5 == num2 || num5 == num3 || num5 == num4){
            num5 = random.nextInt(9);
        }
        System.out.println("Randons: " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5);
        aux.add(list.get(num1));
        aux.add(list.get(num2));
        aux.add(list.get(num3));
        aux.add(list.get(num4));
        aux.add(list.get(num5));
        System.out.println("Auxiliar: " + aux.get(0).getPergunta() + "\n" + aux.get(1).getPergunta() + "\n" +  aux.get(2).getPergunta() + "\n" + aux.get(3).getPergunta() + "\n" + aux.get(4).getPergunta() + "\n");

        return aux;
    }
}
