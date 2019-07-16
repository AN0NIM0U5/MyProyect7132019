package com.example.myproyect7132019;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;


public class FisicaBola extends androidx.appcompat.widget.AppCompatImageView implements ComunicadorDeFragment {

    private int acel;
    private Bitmap pelota, fondo;
    private int tam_pantX, tam_pantY, posX, posY, velX, velY;
    private int tamPelota;
    boolean pelota_sube;
    public void claseBtnInterface(int btnContador){}

    public FisicaBola(Context contexto, int nivel_dificultad) {

        super(contexto);



        WindowManager manejador_ventana=(WindowManager) contexto.getSystemService(Context.WINDOW_SERVICE);

        Display pantalla=manejador_ventana.getDefaultDisplay();

        Point maneja_coord=new Point();

        pantalla.getSize(maneja_coord);

        tam_pantX=maneja_coord.x;

        tam_pantY=maneja_coord.y;


        BitmapDrawable dibujo_fondo=(BitmapDrawable) ContextCompat.getDrawable(contexto, R.drawable.paisaje);

        fondo=dibujo_fondo.getBitmap();//

        fondo=Bitmap.createScaledBitmap(fondo, tam_pantX, tam_pantY, false);


        BitmapDrawable objetoPelota=(BitmapDrawable)ContextCompat.getDrawable(contexto, R.drawable.bola7162019);

        pelota=objetoPelota.getBitmap();

        tamPelota=tam_pantY/3;

        pelota=Bitmap.createScaledBitmap(pelota, tamPelota, tamPelota, false);

        posX=tam_pantX/2-tamPelota/2;

        posY=0-tamPelota;

        acel=nivel_dificultad*(maneja_coord.y/400);




    }

    public boolean toquededo(int x, int y){

        if(y<tam_pantY/3) return false;

        if(velY<=0) return false;

        if(x<posX || x> posX+tamPelota) return false;

        if(y<posY || y>posY+tamPelota) return false;

        velY=-velY;

        double desplX=x-(posX+tamPelota/2);

        desplX=desplX/(tamPelota/2)*velY/2;

        velX+=(int)desplX;
        Log.e("dedo","tokee");
        return true;
    }

    public boolean movimientoBola(){

        if(posX<0-tamPelota){

            posY=0-tamPelota;

            velY=acel;
        }

        posX+=velX;

        posY+=velY;

        if(posY>=tam_pantY) return true;

        if(posX+tamPelota<0 || posX>tam_pantX) return true;

        if(velY<0) pelota_sube=true;

        if(velY>0 && pelota_sube){

            pelota_sube=false;

        }

        velY+=acel;

        return false;
    }

    protected void onDraw(Canvas canvas){

        canvas.drawBitmap(fondo, 0,0, null);

        canvas.drawBitmap(pelota, posX, posY, null);
    }

}