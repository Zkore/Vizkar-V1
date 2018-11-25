package com.iteso.vizkar_v1.beans;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.tools.Constant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class fragmentMisEventos extends Fragment {

    private RecyclerView recyclerView;
    public ArrayList<eventos> eventosArrayList;
    FragmentEventosProximos frags;



    public fragmentMisEventos(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_mis_eventos, container, false);

        ImageView imageViewIfNothing = view.findViewById(R.id.contentImage);
        TextView textNothing = view.findViewById(R.id.text_nothingHere);
        PhotoView photoView = (PhotoView) view.findViewById(R.id.photo_view);
        Button dislike = view.findViewById(R.id.Btn_like_disklike);
        Boolean isSomethingHere = Boolean.TRUE;


        if(isSomethingHere == false) {
            imageViewIfNothing.setVisibility(View.VISIBLE);
            textNothing.setText(R.string.myEvents_nothingInHere);
        }else
            textNothing.setText(R.string.nothing);


        recyclerView = view.findViewById(R.id.recycler_view_mis_eventos);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        eventosArrayList = new ArrayList<>();

        /*
        if(frags.eventosArrayList != null) {
            ArrayList<eventos> eventosArrayList2 = frags.eventosArrayList;
            Log.e("Eventos", "No es nulo la cantidad de elementos son: " + eventosArrayList2.size());
        }
        else
            Log.e("Eventos","Es nulo el arraylist" );

*/


//Para agregar o quitar


        Log.e("Eventos","Vuelve a cargar " );
         eventos eventosAgregar1 = new eventos(1,"Coordenada","Musica","Guadalajara","27 Junio",1,Boolean.TRUE);
        if (eventosAgregar1.getLike() == Boolean.TRUE)
        eventosArrayList.add(eventosAgregar1);
        eventos eventosAgregar2 = new eventos(2,"Pal Norte", "Musica","Monterrey","23 Agosto",2,Boolean.TRUE);
        if (eventosAgregar2.getLike() == Boolean.TRUE) {
            eventosArrayList.add(eventosAgregar2);
        }
        eventos eventosAgregar3 = new eventos(3,"Pal Sur","Musica","Guanajuato","4 Mayo",100,Boolean.FALSE);
        if (eventosAgregar3.getLike() == Boolean.TRUE) {
            eventosArrayList.add(eventosAgregar3);
        }



        //Log.e("Eventos","La cantidad de elementos son: " + eventosArrayList2.size());

        //Log.e("Eventos","La cantidad de elementos son: " + eventosArrayList.size());



        //Hacer myAdapter2 para que solo aparezcan los que doy like
        //MyAdapter myAdapter2 = frags.myAdapter1;
        MyAdapter myAdapter2 = new MyAdapter(Constant.FRAGMENT_MISEVENTOS, getContext(), eventosArrayList);

        recyclerView.setAdapter(myAdapter2);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


}



