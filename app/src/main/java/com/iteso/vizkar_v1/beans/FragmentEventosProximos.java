package com.iteso.vizkar_v1.beans;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;
import com.iteso.vizkar_v1.ActivityViewImage;
import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.tools.Constant;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentEventosProximos extends Fragment {

    public static  ArrayList<eventos> eventosArrayList  = new ArrayList<>();
    public static  Boolean isLoaded = false;
    public static  Boolean isLoadedLogout = false;

    fragmentMisEventos fragmento;

    private RecyclerView recyclerView;
    //public ArrayList<eventos> eventosArrayList;
    public MyAdapter myAdapter1;
    Button verImagen;
    PhotoView photoView ;
    //Boolean isLoaded = false;


    public FragmentEventosProximos(){
        //Required empty
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //return super.onCreateView(inflater, container, savedInstanceState);
        //return inflater.inflate(R.layout.fragment_fragment_eventos_prox, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_eventos_prox, container,false);
        verImagen = view.findViewById(R.id.cambioAVerimagen);

        photoView = view.findViewById(R.id.photo_view);

        recyclerView = view.findViewById(R.id.recycler_view_eventos_proximos);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        //eventosArrayList = new ArrayList<>();
        /*
        eventosArrayList.add(new eventos(1,"Coordenada","Musica","Guadalajara","27 Junio",Boolean.FALSE));
        eventosArrayList.add(new eventos(2,"Pal Norte", "Musica","Monterrey","23 Agosto",Boolean.FALSE));
        eventosArrayList.add(new eventos(3,"PalSur","Musica","Guanajuato","4 Mayo",Boolean.TRUE));
*/
        verImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openZoomImage();
            }
        });


        eventos eventosAgregar1 = new eventos(1,"Coordenada","Musica","Guadalajara","27 Junio",1,Boolean.TRUE);
        eventos eventosAgregar2 = new eventos(2,"Pal Norte", "Musica","Monterrey","23 Agosto",2,Boolean.TRUE);
        eventos eventosAgregar3 = new eventos(3,"Pal Sur","Musica","Guanajuato","4 Mayo",100,Boolean.FALSE);

        if(isLoadedLogout == false) {
            if (isLoaded == false) {
                eventosArrayList.add(eventosAgregar1);
                eventosArrayList.add(eventosAgregar2);
                eventosArrayList.add(eventosAgregar3);

                Log.e("openZoomImage","Es llamado");

                isLoaded = true;
            }
        }
        myAdapter1 = new MyAdapter(Constant.FRAGMENT_EVENTOSPROXIMOS, getContext(), eventosArrayList);
         //myAdapter1 = new MyAdapter(Constant.FRAGMENT_MISEVENTOS, getContext(), eventosArrayList);

        recyclerView.setAdapter(myAdapter1);
    }

    public void openZoomImage(){
        Log.e("openZoomImage","Es casteado");
        Intent intent = new Intent(getActivity() , ActivityViewImage.class);
        startActivity(intent);
    }

/*
    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences valor = getSharedPreferences(eventosArrayList, 0);
        SharedPreferences.Editor editor = valor.edit();
        editor.putString("Eventos", String.valueOf(eventosArrayList));
        editor.commit();
    }
*/


}
