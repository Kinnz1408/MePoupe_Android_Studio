package com.example.henriquel.mepoupegame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by HenriqueL on 11/05/2017.
 */
public class Casa_Class {
    main main_activity;
    public Bitmap casa_Class_bitmap;
    Context context;
    ImageButton ib_carta;
    int b ;


    public Casa_Class(Context current, main main_activity) {

        this.context = current;
        this.main_activity = main_activity;
       // b = main_activity.RRV;


        if (main_activity.DayCount >= 0 && main_activity.DayCount <= 2) {
            casa_Class_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.quadrado_a);

        }
        if (main_activity.DayCount == 3) {
            casa_Class_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.quadrado_azul);

        }
        if (main_activity.DayCount == 4 || main_activity.DayCount == 5) {
            casa_Class_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.quadrado_preto);

        }
        if (main_activity.DayCount >= 6) {
            casa_Class_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.quadrado_email);

        }

    }
    }



