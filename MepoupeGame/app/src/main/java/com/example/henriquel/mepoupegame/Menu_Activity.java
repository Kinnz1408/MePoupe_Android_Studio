package com.example.henriquel.mepoupegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by HenriqueL on 06/05/2017.
 */
public class Menu_Activity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        Button play_button = (Button) findViewById(R.id.play_button);
        Button credits_button = (Button) findViewById(R.id.credits_button);
        Button instruction_button = (Button) findViewById(R.id.instruction_button);


       play_button.setOnClickListener(new View.OnClickListener() {


           @Override
            public void onClick(View v) {
                // setContentView(R.layout.play_activity);
               Intent I = new Intent(Menu_Activity.this,ModeSelection_Activity.class);
               startActivity((I));
            }

        });
        credits_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // setContentView(R.layout.play_activity);
                Intent I = new Intent(Menu_Activity.this,Credits_Activity.class);
                startActivity((I));
            }

        });
        instruction_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // setContentView(R.layout.play_activity);
                Intent I = new Intent(Menu_Activity.this,Instruction_Activity.class);
                startActivity((I));
            }

        });
    }
}
