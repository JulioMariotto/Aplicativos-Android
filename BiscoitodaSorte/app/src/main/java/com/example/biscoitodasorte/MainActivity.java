package com.example.biscoitodasorte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String frases[] = {
                        "A vida trará coisas boas se tiveres paciência.",
                        "Demonstre amor e alegria em todas as oportunidades e verás que a paz nasce dentro de você.",
                        "Não compense na ira o que lhe falta na razão.",
                        "Defeitos e virtudes são apenas dois lados da mesma moeda.",
                        "A maior de todas as torres começa no solo.",
                        "Não há que ser forte. Há que ser flexível.",
                        "Gente todo dia arruma os cabelos, por que não o coração?",
                        "Há três coisas que jamais voltam; a flecha lançada, a palavra dita e a oportunidade perdida.",
                        "A juventude não é uma época da vida, é um estado de espírito.",
                        "Podemos escolher o que semear, mas somos obrigados a colher o que plantamos.",
                        "Dê toda a atenção para a formação dos teus filhos, sobretudo por exemplos de tua própria vida.",
                        "Siga os bons e aprenda com eles.",
                        "Não importa o tamanho da montanha, ela não pode tapar o sol.",
                        "O bom-senso vai mais longe do que muito conhecimento.",
                        "Quem quer colher rosas deve suportar os espinhos.",
                        "São os nossos amigos que nos ensinam as mais valiosas lições.",
                        "Uma iniciativa mal-sucedida não significa o final de tudo. Sempre existe uma nova oportunidade.",
                        "Aquele que se importa com o sentimento dos outros, não é um tolo.",
                        "A adversidade é um espelho que reflete o verdadeiro eu.",
                        "Lamentar aquilo que não temos é desperdiçar aquilo que já possuímos."
    };
    Random r;
    int sort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();
    }

    public void show(View view){
        TextView output = (TextView) findViewById(R.id.output);
        Button active = (Button) findViewById(R.id.action);
        sort = r.nextInt(19);
        output.setText(frases[sort]);
        active.setVisibility(View.GONE);
    }
}
