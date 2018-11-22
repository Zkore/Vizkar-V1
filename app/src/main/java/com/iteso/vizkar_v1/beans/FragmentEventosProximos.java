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
import com.iteso.vizkar_v1.tools.Constant;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentEventosProximos extends Fragment {

    private RecyclerView recyclerView;
    public ArrayList<eventos> eventosArrayList;
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
        eventosArrayList = new ArrayList<>();
        eventosArrayList.add(new eventos(1,"Coordenada","Musica","Guadalajara","27 Junio"));
        eventosArrayList.add(new eventos(2,"Pal Norte", "Musica","Monterrey","23 Agosto"));
        eventosArrayList.add(new eventos(3,"PalSur","Musica","Guanajuato","4 Mayo"));

        MyAdapter myAdapter1 = new MyAdapter(Constant.FRAGMENT_EVENTOSPROXIMOS, getContext(), eventosArrayList);
        recyclerView.setAdapter(myAdapter1);
    }


}
