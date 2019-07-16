package com.example.myproyect7132019;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import androidx.fragment.app.Fragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class JuegoPlaying extends Fragment {
    private final int[] BOTONAYUDA = {R.id.btnAyuda,R.id.dificil,R.id.facil,R.id.medio};


    public JuegoPlaying() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_juego_playing, container, false);
        View m = inflater.inflate(R.layout.juego_bola, container, false);
        Button btnmenu;

        for (int i=0;i<BOTONAYUDA.length; i++) {

            btnmenu = (Button) m.findViewById(BOTONAYUDA[i]);

            final int btnContador = i;

            btnmenu.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Activity activity = getActivity();

                    ((ComunicadorDeFragment) activity).claseBtnInterface(btnContador);
                }

            });

        }


return  inflater.inflate(R.layout.juego_bola, container, false);
    }


}
