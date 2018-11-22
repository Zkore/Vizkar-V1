package com.iteso.vizkar_v1.beans;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.iteso.vizkar_v1.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentEventosProximos extends Fragment {

    Button proximidadBtn, generoBtn;


    public FragmentEventosProximos(){
        //Required empty
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //return super.onCreateView(inflater, container, savedInstanceState);
        //return inflater.inflate(R.layout.fragment_fragment_eventos_prox, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_eventos_prox, container,false);

        proximidadBtn = view.findViewById(R.id.porProximidadBtn);
        generoBtn = view.findViewById(R.id.PorGeneroBtn);

        //On Hold
        /*
        proximidadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                FragmentEventosProximosDespuesDeFiltro fragment = new FragmentEventosProximosDespuesDeFiltro();
                transaction.replace(R.id.ViewPager_Main, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        */

        return view;
    }
}
