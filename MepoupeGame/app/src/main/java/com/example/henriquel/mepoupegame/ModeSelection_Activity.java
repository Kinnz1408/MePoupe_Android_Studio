package com.example.henriquel.mepoupegame;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by HenriqueL on 06/05/2017.
 */
public class ModeSelection_Activity extends Activity {
    public int Boy_or_Girl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode_selection);
        ImageButton boy_button = (ImageButton) findViewById(R.id.boy_icon);
        ImageButton girl_button = (ImageButton) findViewById(R.id.girl_icon);
        final EditText Nome_do_Pestinha = (EditText) findViewById(R.id.Nome_do_Pestinha);



        boy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Boy_or_Girl=1;
               String nome_dele =Nome_do_Pestinha.getText().toString();
                Intent I = new Intent(ModeSelection_Activity.this,main.class);
                I.putExtra("Boy_or_Girl",1);
                I.putExtra("Nome_do_Pestinha",nome_dele);
                startActivity(I);
            }

        });
        girl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boy_or_Girl=2;
                String nome_dele =Nome_do_Pestinha.getText().toString();
                Intent I = new Intent(ModeSelection_Activity.this,main.class);
                I.putExtra("Boy_or_Girl",2);
                I.putExtra("Nome_do_Pestinha",nome_dele);
                startActivity((I));
            }

        });



    }
}
