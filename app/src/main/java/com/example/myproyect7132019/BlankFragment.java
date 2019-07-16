package com.example.myproyect7132019;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private final int[] BOTONAYUDA = {R.id.btnAyuda,R.id.facil,R.id.medio,R.id.dificil,};
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View m = inflater.inflate(R.layout.fragment_blank, container, false);


        Button btnmenu;

        for (int i=0;i<BOTONAYUDA.length; i++){

            btnmenu=(Button) m.findViewById(BOTONAYUDA[i]);

            final int btnContador = i;
            btnmenu.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {

                    Activity activity = getActivity();


                    ((ComunicadorDeFragment) activity).claseBtnInterface(btnContador);
                }

            });
        }

        return m;

    }

}
