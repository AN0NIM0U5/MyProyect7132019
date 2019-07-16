package com.example.myproyect7132019;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import java.time.temporal.JulianFields;

//import androidx.fragment.app.Fragment;



//main Activity
public class JuegoBola extends FragmentActivity  implements ComunicadorDeFragment {

    MediaPlayer mediaPlayerComing;
    MediaPlayer mediaPlayerClickbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_bola);
        mediaPlayerComing= MediaPlayer.create(this, R.raw.darkcarpenterlong);
        mediaPlayerClickbutton= MediaPlayer.create(this, R.raw.blockimpactii);

        Log.e("ONcreate view ", "R layout juego_bola");

    }




    public void claseBtnInterface(int btnContador) {
        Intent in = new Intent(this, JulianFields.class);
        in.putExtra("BOTONAYUDA", btnContador);
        if (btnContador == 0) {
            Log.e("ONcreate view ", "Estoy cargando ayuda ");
            Intent intent = new Intent(this, Help.class);
            mediaPlayerClickbutton.start();
            startActivity(intent);
        } else {

            int dificultad = 0;

            Intent intt = new Intent(this, PartidaState.class);

            //intt.putExtra("BOTONAYUDA", dificultad);


            if (btnContador == 1) {
                intt.putExtra("BOTONAYUDA",dificultad=1);
                //dificultad = 1;

                Log.e("DIFICULTAD view ", "facil ");

            }
            if (btnContador == 2) {
                intt.putExtra("BOTONAYUDA",dificultad=2);
               // dificultad = 2;
                Log.e("DIFICULTAD view ", "medio ");
            }
            if (btnContador == 3) {
                dificultad = 3;
                intt.putExtra("BOTONAYUDA",dificultad=3);

                Log.e("DIFICULTAD view ", "dificil ");
            }


            mediaPlayerClickbutton.start();
            mediaPlayerComing.start();
            startActivityForResult(intt, 1);

            Log.e("ONcreate view ", "PARTIDAESTATE ");


        }

    }

    protected void onActivityResult(int petic, int cod, Intent puntacion){
    if (petic!=1 || cod!=RESULT_OK) return;;

    int resultado = puntacion.getIntExtra("PUNTUACION" ,0);

        TextView caja = findViewById(R.id.record);

        caja.setText("Record:  " + resultado);
        mediaPlayerComing.stop();
    }



}




/*


///


   if (btnContador == 1) {

            }
            if (btnContador == 2) {

            }
            if (btnContador==3) {



else {

            int dificultad;
            if (btnContador == 1) {
                dificultad=1;
                Log.e("ONcreate view ", "facil ");

            }
            if (btnContador == 2) {
                dificultad = 2;
                Log.e("ONcreate view ", "medio ");
            }
            if (btnContador==3) {
                dificultad =3;
                Log.e("ONcreate view ", "dificil ");
            }

            Intent intt = new Intent(this, PartidaState.class);
            startActivity(intt);
            Log.e("ONcreate view ", "PARTIDAESTATE ");

        }






 public void claseBtnInterface(int btnContador){}
    public void dificultad(View view){
        String dif=(String) ((Button) view).getText();
        int dificultad=0;
        if (dif.equals("facil")) dificultad=1;
        Log.e("MultiplicaX1", "facil ");
        if (dif.equals("medio")) dificultad = 2;
        Log.e("multiplicaX2", "medio ");
        if (dif.equals("dificil")) dificultad =3;
        Log.e("MultiplicaX3", "dificil ");

        Intent inn = new Intent(this, PartidaState.class);
        inn.putExtra("DIFICULTAD",dificultad);
        startActivity(inn);
        Log.e(" view ", "PARTIDAESTATE ");

    }






///


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.help_fragment, container, false);

        return v;
    }


////////////////////

Fragment[] misFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_de_juego);

        misFragments = new Fragment[3];
        misFragments[0]= new HelpFragment();
        misFragments[1]= new JuegoPlaying();
        misFragments[2]= new HelpFragment();
        Bundle extras= getIntent().getExtras();
        claseBtnInterface(extras.getInt("BOTONAYUDA"));

    }

    public void claseBtnInterface(int btnContador ){
        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, misFragments[btnContador]);
        fragmentTransaction.commit();
    }

//////////////////













    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.help_fragment, container, false);

        return v;
    }



 btnHelp = (findViewById(R.id.btnAyuda));
         Log.e("JUEGO BOLA ACTIVITY", "estoy aqui");
         btnHelp.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Log.e("on click  -__-", "estoy aqui");
        claseBtnInterface(R.layout.help_fragment);
        }
        });

    public  void ayudaxml (View v){ Intent in = new Intent(this, HelpFragment.class);
        startActivity(in);
    }


 misFragments = new Fragment[0];
        misFragments[0]= new HelpFragment();
        Bundle extras= getIntent().getExtras();
        claseBtnInterface(extras.getInt("BOTONAYUDA"));


 style="@style/pantalla"



   private final int[] BOTONAYUDA = {R.id.btnAyuda,R.id.dificil,R.id.facil,R.id.medio};


 FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
       fragmentTransaction.replace(R.id.contenedorDeBotones, misFragments[btnContador]);



   <fragment
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/HelpFragment"
        android:name="com.example.myproyect7132019.HelpFragment">
    </fragment>



@Override
    public void claseBtnInterface(int btnContador ) {
        Intent in = new Intent(this, HelpFragment.class);
                in.putExtra("BOTONAYUDA", btnContador);
        startActivity(in);

    }

    Button btnHelp;
    Fragment[] misFragments;


  <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/contenedorDeBotones">
    </RelativeLayout>

*/