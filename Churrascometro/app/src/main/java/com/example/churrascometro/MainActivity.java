package com.example.churrascometro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBarHomem, seekBarMulher, seekBarCriança;
    TextView textViewHomem, textViewMulher, textViewCrianca, textViewNumHomem, textViewNumMulher, textViewNumCrianca, resultadoLinguica, resultadoCarne, resultadoCerveja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarHomem = (SeekBar) findViewById(R.id.seekBarHomem);
        seekBarMulher = (SeekBar) findViewById(R.id.seekBarMulher);
        seekBarCriança = (SeekBar) findViewById(R.id.seekBarCrianca);
        textViewNumHomem = (TextView) findViewById(R.id.textViewNumHomem);
        textViewNumMulher = (TextView) findViewById(R.id.textViewNumMulher);
        textViewNumCrianca = (TextView) findViewById(R.id.textViewNumCrianca);
        resultadoLinguica = (TextView) findViewById(R.id.resultadoLinguica);
        resultadoCarne = (TextView) findViewById(R.id.resultadoCarne);
        resultadoCerveja = (TextView) findViewById(R.id.resultadoCerveja);

        resultadoLinguica.setText("Linguiça: 0 Kg");
        resultadoCarne.setText("Carne: 0 Kg");
        resultadoCerveja.setText("Cerveja: 0 Litros");

        textViewNumHomem.setText("0");
        textViewNumMulher.setText("0");
        textViewNumCrianca.setText("0");

        seekBarHomem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewNumHomem.setText(String.valueOf(progress));
                calcular(progress, seekBarMulher.getProgress(), seekBarCriança.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarMulher.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewNumMulher.setText(String.valueOf(progress));
                calcular(seekBarHomem.getProgress(), progress, seekBarCriança.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarCriança.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewNumCrianca.setText(String.valueOf(progress));
                calcular(seekBarHomem.getProgress(), seekBarMulher.getProgress(), progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calcular(int homemProgress, int mulherProgress, int criancaProgress){
        float linguica, carne;
        int cerveja;

        resultadoLinguica.setText("Linguiça: " + String.format("%.2f", (homemProgress * 0.250) + (mulherProgress * 0.200) + (criancaProgress * 0.100)) + "Kg");
        resultadoCarne.setText("Carne: " + String.format("%.2f", ((homemProgress * 0.500) + (mulherProgress * 0.300) + (criancaProgress * 0.200))) + "Kg");
        resultadoCerveja.setText("Cerveja: " + ((homemProgress * 3) + (mulherProgress * 2)) + "Litros");
    }
}
