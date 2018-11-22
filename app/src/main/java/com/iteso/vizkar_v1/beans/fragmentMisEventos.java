package com.iteso.vizkar_v1.beans;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.tools.Constant;

import java.util.ArrayList;


public class fragmentMisEventos extends Fragment {

    private RecyclerView recyclerView;
    public ArrayList<eventos> eventosArrayList;



    public fragmentMisEventos(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_mis_eventos, container, false);

        ImageView imageViewIfNothing = view.findViewById(R.id.contentImage);
        TextView textNothing = view.findViewById(R.id.text_nothingHere);
        Button dislike = view.findViewById(R.id.Btn_like_disklike);
        Boolean isSomethingHere = Boolean.TRUE;


        if(isSomethingHere == false) {
            imageViewIfNothing.setVisibility(View.VISIBLE);
            textNothing.setText(R.string.myEvents_nothingInHere);
        }else
            textNothing.setText(R.string.nothing);


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
        eventosArrayList = new ArrayList<>();
        eventosArrayList.add(new eventos(1,"Coordenada","Musica","Guadalajara","27 Junio"));
        eventosArrayList.add(new eventos(2,"Pal Norte", "Musica","Monterrey","23 Agosto"));
        eventosArrayList.add(new eventos(3,"PalSur","Musica","Guanajuato","4 Mayo"));

        //Hacer myAdapter2 para que solo aparezcan los que doy like
        MyAdapter myAdapter1 = new MyAdapter(Constant.FRAGMENT_EVENTOSPROXIMOS, getContext(), eventosArrayList);
        recyclerView.setAdapter(myAdapter1);
    }
}
