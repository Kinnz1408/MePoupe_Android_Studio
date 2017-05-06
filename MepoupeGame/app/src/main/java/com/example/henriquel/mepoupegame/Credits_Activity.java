package com.example.henriquel.mepoupegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by HenriqueL on 06/05/2017.
 */
public class Credits_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits_layout);
        Button credits_back = (Button) findViewById(R.id.credits_button_back);
        credits_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // setContentView(R.layout.play_activity);
                Intent I = new Intent(Credits_Activity.this,Menu_Activity.class);
                startActivity((I));
            }


        });

    }
}
