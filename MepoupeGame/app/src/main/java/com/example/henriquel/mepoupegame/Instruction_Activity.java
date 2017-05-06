package com.example.henriquel.mepoupegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by HenriqueL on 06/05/2017.
 */
public class Instruction_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruction_layout);
        Button instruction_back = (Button) findViewById(R.id.instruction_button_back);
        instruction_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // setContentView(R.layout.play_activity);
                Intent I = new Intent(Instruction_Activity.this,Menu_Activity.class);
                startActivity((I));
            }


        });
    }
}
