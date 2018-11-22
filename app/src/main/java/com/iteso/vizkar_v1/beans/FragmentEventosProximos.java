package com.iteso.vizkar_v1.beans;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.iteso.vizkar_v1.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentEventosProximos extends Fragment {

    private RecyclerView recyclerView;
    ArrayList<eventos> eventos;
    MyAdapter adapterEvent;


    public FragmentEventosProximos(){
        //Required empty
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //return super.onCreateView(inflater, container, savedInstanceState);
        //return inflater.inflate(R.layout.fragment_fragment_eventos_prox, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_eventos_prox, container,false);
        recyclerView = view.findViewById(R.id.recycler_view);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        MyAdapter myAdapter = new MyAdapter();
        eventos = new ArrayList<>();
        eventos.add(new eventos(1,"Coordenada","Musica","Guadalajara"));
        eventos.add(new eventos(2,"Pal Norte", "Musica","Monterrey"));
        eventos.add(new eventos(3,"PalSur","Musica","Guanajuato"));


        recyclerView.setAdapter(myAdapter);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}




        /*
        proximidadBtn = view.findViewById(R.id.porProximidadBtn);
        generoBtn = view.findViewById(R.id.PorGeneroBtn);

        //On Hold

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
