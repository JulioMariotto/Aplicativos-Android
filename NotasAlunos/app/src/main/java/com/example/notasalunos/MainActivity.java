package com.example.notasalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nomeAluno, nota1, nota2, frequencia;
    TextView resultado, media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeAluno = (EditText) findViewById(R.id.nomeAlunoEditText);
        nota1 = (EditText) findViewById(R.id.nota1EditText);
        nota2 = (EditText) findViewById(R.id.nota2EditText);
        frequencia = (EditText) findViewById(R.id.freqEditText);
        resultado = (TextView) findViewById(R.id.resultadoTextView);
        media = (TextView) findViewById(R.id.mediaTextView);
    }

    public void calcula(View view){

        if(nomeAluno.length() == 0){
            Toast.makeText(this, "Forneça o nome do Aluno!", Toast.LENGTH_LONG).show();
            return;
        }
        else if(nota1.length() == 0){
            Toast.makeText(this, "Forneça a nota 1!", Toast.LENGTH_LONG).show();
            return;
        }
        else if(nota2.length() == 0){
            Toast.makeText(this, "Forneça a nota 2!", Toast.LENGTH_LONG).show();
            return;
        }
        else if(frequencia.length() == 0){
            Toast.makeText(this, "Forneça a frequencia", Toast.LENGTH_LONG).show();
            return;
        }
        else {

            String aluno = nomeAluno.getText().toString();
            float nota1Aluno = Float.parseFloat(nota1.getText().toString());
            float nota2Aluno = Float.parseFloat(nota2.getText().toString());
            int frequenciaAluno = Integer.parseInt(frequencia.getText().toString());


            if(nota1Aluno > 10 || nota1Aluno < 0){
                Toast.makeText(this, "Forneça uma nota entre 0 e 10!", Toast.LENGTH_LONG).show();
                return;
            }
            else if(nota2Aluno > 10 || nota2Aluno < 0){
                Toast.makeText(this, "Forneça uma nota entre 0 e 10!", Toast.LENGTH_LONG).show();
                return;
            }
            else if(frequenciaAluno > 100 || frequenciaAluno < 0){
                Toast.makeText(this, "Forneça uma frequencia entre 0 e 100!", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                float mediaAluno = (nota1Aluno + nota2Aluno) / 2;

                if(mediaAluno < 4){
                    media.setText("Média:" + mediaAluno );
                    resultado.setText("Reprovado por Nota");
                    return;
                }
                else if(frequenciaAluno < 75){
                    media.setText("Média:" + mediaAluno );
                    resultado.setText("Reprovado por Falta");
                    return;
                }
                else if(mediaAluno < 7){
                    media.setText("Média:" + mediaAluno );
                    resultado.setText("Final");
                    return;
                }
                else{
                    media.setText("Média:" + mediaAluno );
                    resultado.setText("Aprovado");
                    return;
                }
            }
        }
    }
}
