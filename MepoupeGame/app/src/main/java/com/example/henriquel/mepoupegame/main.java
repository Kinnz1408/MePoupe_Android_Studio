package com.example.henriquel.mepoupegame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;



public class main extends Activity {
    //Assets
    private ImageButton b_dado;
    private ImageButton ib_carta;
    private ImageView imageView_boyzo;
    TextView t_alegria;
    TextView t_dinheio;
    //Tabuleiro
    private int ScaleValue = 20;
    private int ScalePlayerValue = 15;
    private int ValueY = 0;
    private int ValueX = 45;
    int x =45;
    int y =0;
    int CountCasas = 0;
    int[] casax = new int[35];
    int[] casay = new int[35];
    int RRV;
    //Mecânica
    Random dado;
    int contador_da_conta_pesada;
    int contador_semanas;
    Random cartas;
    int n_carta;
    //Variáveis de Controle
    boolean andou;
    float time_to_show_carta =100;
    boolean carta_na_tela;
    //Variáveis de Status do Jogador
    public  int alegria=50;
    public  int dinheiro=50;

    //Importanto Outros Classes
    private Object context;

    // Teste
    int[] Dias_Semana ;
    int DayCount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Recebendo Valor da outra Activity para determina se vai ser menina ou menino e o nome
        final int player_Sex = getIntent().getIntExtra("Boy_or_Girl",0);
        final String nome_do_Pestinha = getIntent().getStringExtra("Nome_do_Pestinha");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Declando os Elementos do Layout ou no Drawable
        b_dado=(ImageButton) findViewById(R.id.dado);
        final FrameLayout container = (FrameLayout) findViewById(R.id.frame);
        Bitmap t_quadrado= BitmapFactory.decodeResource(getResources(), R.drawable.quadrado_preto);
        imageView_boyzo =(ImageView) findViewById(R.id.boyzo);
        ib_carta=(ImageButton) findViewById(R.id.carta);
        t_alegria = (TextView) findViewById(R.id.alegria);
        t_dinheio= (TextView) findViewById(R.id.dinheiro);







        b_dado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dado = new Random();
                int i1 = dado.nextInt(6 - 0) + 1;
                contador_da_conta_pesada +=i1;
               // dinheiro-=100;

                if (contador_da_conta_pesada>=7){
                    contador_da_conta_pesada-=7;
                    contador_semanas++;
                    Log.d("Criação", "Olha ,Conta pesada chegou!!!!");
                }
                RRV += i1;
                andou=true;
                b_dado.setVisibility(View.INVISIBLE);
                SpawnCarta();
                carta_na_tela=true;

                if (RRV>=31){
                    Intent I = new Intent(main.this,Score_Activity.class);
                    //      I.putExtra("Nome_do_Pestinha",nome_do_Pestinha);
                    I.putExtra("dinheiro",dinheiro);
                    I.putExtra("alegria",alegria);
                    I.putExtra("Nome_do_Pestinha",nome_do_Pestinha);
                    startActivity(I);
                    Log.d("Movimentação", "A variável andou é :"+RRV+", viu");

                }





            }

        });
        ib_carta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //   Log.d("Carta", "A carta foi Apertada !");
                ib_carta.setVisibility(View.INVISIBLE);
                b_dado.setVisibility(View.VISIBLE);
                StatusRandom();
                carta_na_tela=false;



                if (dinheiro<=0||alegria<=0){
                    Intent I = new Intent(main.this,Score_Activity.class);
                    //      I.putExtra("Nome_do_Pestinha",nome_do_Pestinha);
                    I.putExtra("dinheiro",dinheiro);
                    I.putExtra("alegria",alegria);
                    I.putExtra("Nome_do_Pestinha",nome_do_Pestinha);
                    startActivity(I);
                  //  Log.d("Movimentação", "A variável andou é :"+dinheiro+", viu");

                }



            }

        });




        SortCards();
        for (int i = 0; i < 31; ++i) {

            if (CountCasas<1){
                DayCount =Dias_Semana[1];
            }
            imageView_boyzo.bringToFront();
            addScaledImageView(ScaleValue,container);

            CountCasas ++;

            casax[i]=ValueX;
            casay[i]=ValueY;
            ValueX +=100;
            Log.d("Criação", "Olha ,DayCount é "+DayCount+" viu");

            if (CountCasas>=7){
                ValueY +=100;
                ValueX =45;
                CountCasas =0;

            }
            DayCount =Dias_Semana[CountCasas];



        }






        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(0,20);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {









                                BringToFront(imageView_boyzo);
                                imageView_boyzo.setX(x);
                                imageView_boyzo.setY(y);
                                imageView_boyzo.setVisibility(View.VISIBLE);
                                if (imageView_boyzo.getX()<casax[RRV]){

                                    x++;

                                }
                                if (imageView_boyzo.getX()>casax[RRV]){

                                    x--;

                                }
                                if (imageView_boyzo.getY()<casay[RRV]){

                                    y++;

                                }
                                if (imageView_boyzo.getY()>casay[RRV]){

                                    y--;

                                }
                                if (imageView_boyzo.getX()==casax[0]&&imageView_boyzo.getY()==casay[0]){

                                   // Log.d("Movimentação", "Olha , tô na casa inicial , viu");
                                }else {
                                     int a;
                                     a=RRV+1;
                                  //  Log.d("Movimentação", "Olha,tô na casa "+a +", viu");
                                }
                                if(andou){
                                    time_to_show_carta--;
                                    if (time_to_show_carta<0){
                                        ib_carta.setVisibility(View.VISIBLE);
                                        time_to_show_carta=100;
                                        andou=false;
                                    }


                                }






                                   // Log.d("Passou esse carai", "O nome do nojento é :"+contador_da_conta_pesada+", viu");

                             //   Log.d("Movimentação", "A variável andou é :"+andou +", viu");

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();


    }

    public boolean onTouchEvent(MotionEvent me){
        if (me.getAction()==MotionEvent.ACTION_DOWN){



        }
        return  true;
    }
    private void addScaledImageView( int sampleSize , FrameLayout container) {


        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = sampleSize;

        Casa_Class casa_class= new Casa_Class(this,this);
      // Bitmap scaledBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.quadrado_preto, bitmapOptions);
        Bitmap scaledBitmap= casa_class.casa_Class_bitmap;



        FrameLayout rl = (FrameLayout) findViewById(R.id.frame);
        FrameLayout.LayoutParams params;
        ImageView scaledImageView = new ImageView(this);
        params = new FrameLayout.LayoutParams(80,80);
        params.leftMargin = ValueX;
        params.topMargin = ValueY;
        rl.addView(scaledImageView, params);
        scaledImageView.setImageBitmap(scaledBitmap);


    }

    void SpawnCarta(){
        Casa_Class casa_class= new Casa_Class(this,this);
       // cartas = new Random();
      //  n_carta = cartas.nextInt(8 - 0) + 1;
        n_carta=contador_da_conta_pesada;
        ib_carta.bringToFront();

              //2            //6

        if (Dias_Semana[0]==n_carta) {
            ib_carta.setImageResource(R.drawable.carta);
        }
        if (Dias_Semana[1]==n_carta){
            ib_carta.setImageResource(R.drawable.carta_1);

        }
        if (Dias_Semana[1+1]==n_carta){
            ib_carta.setImageResource(R.drawable.carta_2);

        }
        if (Dias_Semana[2+1]==n_carta){
            ib_carta.setImageResource(R.drawable.carta_3);
        }
        if (Dias_Semana[3+1]==n_carta){
            ib_carta.setImageResource(R.drawable.carta_4);
        }
        if (Dias_Semana[4+1]==n_carta){
            ib_carta.setImageResource(R.drawable.carta_5);
        }
        if (Dias_Semana[5+1]==n_carta){
            ib_carta.setImageResource(R.drawable.carta_6);
        }



        Log.d("Carta", "A Carta que você pegou foi :"+n_carta +", viu");


    }
    void StatusRandom(){


        if (n_carta==1){
            alegria+=10;


        }
        if (n_carta==2){
            alegria-=10;


        }
        if (n_carta==3){
            dinheiro+=10;

        }
        if (n_carta==4){
            dinheiro-=10;

        }
        if (n_carta==5){
            alegria+=10;
            dinheiro-=10;
        }
        if (n_carta==6){
            alegria-=10;
            dinheiro+=10;
        }
        if (n_carta==7){
            alegria+=10;
            dinheiro+=10;
        }
        if (n_carta==8){
            alegria-=10;
            dinheiro-=10;

        }
        t_alegria.setText("Alegria :"+alegria);
        t_dinheio.setText("Dinheiro :"+dinheiro);


    }
      void BringToFront(ImageView imageView){
        if (!carta_na_tela){
            imageView.bringToFront();

        }


      }

    public  void SortCards() {
        int x[] = {0,1,2,3,4,5,6};
        int i = 0;
        while (i < x.length) {
            x[i] = (int) (Math.random() * 7);
            boolean flag = true;
            for (int j = 0; j < i; j++)
            {
                if (x[j] == x[i])
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
                i++;
           // Log.d("Sort Cards Void ", "A Carta que você pegou foi : , viu");


        }
        Dias_Semana=x;
        Log.d("this is my array", "arr: " + Arrays.toString(Dias_Semana));

    }

}


