package com.example.henriquel.mepoupegame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HenriqueL on 09/05/2017.
 */
public class Score_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        int dinheiro = getIntent().getIntExtra("dinheiro",0);
        int alegria = getIntent().getIntExtra("alegria",0);
        String nome_do_Pestinha = getIntent().getStringExtra("Nome_do_Pestinha");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);

        TextView dinheiro_t = (TextView) findViewById(R.id.dinheiroScore);
        TextView alegria_t = (TextView) findViewById(R.id.alegriaScore);
        TextView Nome_Score = (TextView) findViewById(R.id.nome_Score);

        Log.d("Menino", "A variável andou é :"+dinheiro+", viu");
        dinheiro_t.setText("DINHEIRO :"+dinheiro);
        alegria_t.setText("ALEGRIA :"+alegria);
        Nome_Score.setText(nome_do_Pestinha);





    }
}
