package com.example.myproyect7132019;

//import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;


public class PartidaState extends Activity {

    private FisicaBola partida;
    private int dificultad;
    private int FPS = 30;
    private Handler temporizador;
    private int botes;
    MediaPlayer golpe;
    MediaPlayer looser;
    MediaPlayer mediaPlayerComing;



    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        botes = 0;
        Bundle extras= getIntent().getExtras();
        dificultad= extras.getInt("BOTONAYUDA",dificultad);
        partida= new FisicaBola (getApplicationContext(),dificultad);
        setContentView(partida);
        temporizador= new Handler();
        temporizador.postDelayed(hilo,900);
        golpe= MediaPlayer.create(this, R.raw.mech_hit_touch);
        looser= MediaPlayer.create(this, R.raw.arcadecasino);
       // mediaPlayerComing = MediaPlayer.create(this.getIntent(JuegoBola.AUDIO_SERVICE),R.raw.darkcarpenterlong);
        mediaPlayerComing = MediaPlayer.create(this,R.raw.darkcarpenterlong);

    }



    private  Runnable hilo = new Runnable() {

        @Override
        public void run() {
            if (partida.movimientoBola()) fin();
            else{
                partida.invalidate();
                temporizador.postDelayed(hilo, 100/FPS);

            }
        }

    };

    public boolean onTouchEvent(MotionEvent event){

        int x= (int)event.getX();
        int y= (int)event.getY();
     if  (partida.toquededo(x,y))botes++; Log.e("s","cuenta bote");
            golpe.start();

    return  false;
    }

    public void fin(){
        //looser.start()
        temporizador.removeCallbacks(hilo);
        Intent intent = new Intent();
        intent.putExtra("PUNTUACION",botes);
        setResult(RESULT_OK,intent);
        looser.start();
        mediaPlayerComing.stop();
        Log.e("s","cuenta PUNTUACION");
        finish();
    }
}
