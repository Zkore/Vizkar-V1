package com.iteso.vizkar_v1.beans;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.tools.Constant;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.iteso.vizkar_v1.tools.Constant.TYPE_MUSICA;


public class fragmentMisEventos extends Fragment {

    DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference firebaseName = FirebaseDatabase.getInstance().getReference().child("NombreDeEventos");

    private RecyclerView recyclerView;
    public ArrayList<eventos> eventosArrayList;
    FragmentEventosProximos frags;
    int i = 0;



    public fragmentMisEventos(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("IniApp","Se creo en fragment onCreateView mis Eventos");

        View view = inflater.inflate(R.layout.fragment_fragment_mis_eventos, container, false);

        ImageView imageViewIfNothing = view.findViewById(R.id.contentImage);
        TextView textNothing = view.findViewById(R.id.text_nothingHere);
        PhotoView photoView = (PhotoView) view.findViewById(R.id.photo_view);
        Button dislike = view.findViewById(R.id.Btn_like_disklike);
        ImageButton refresh = view.findViewById(R.id.refresh);
        Boolean isSomethingHere = Boolean.TRUE;


        if(isSomethingHere == false) {
            imageViewIfNothing.setVisibility(View.VISIBLE);
            textNothing.setText(R.string.myEvents_nothingInHere);
        }else
            textNothing.setText(R.string.nothing);


        recyclerView = view.findViewById(R.id.recycler_view_mis_eventos);


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction refreshFragment = getFragmentManager().beginTransaction();
                refreshFragment.detach(fragmentMisEventos.this).attach(fragmentMisEventos.this).commit();
                //Log.e("Fragment","Detach & atached");
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("IniApp","Se creo en onActivityCreated fragment mis Eventos");
        super.onActivityCreated(savedInstanceState);
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        eventosArrayList = new ArrayList<>();

//Para agregar o quitar


        //Log.e("Eventos","Vuelve a cargar " );
         eventos eventosAgregar1 = new eventos(1,"Coordenada",1,"Guadalajara","27 Junio",1,Boolean.TRUE);
        if (eventosAgregar1.getLike() == Boolean.TRUE)
        eventosArrayList.add(eventosAgregar1);

        firebaseName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String name = ds.getKey();
                    //Log.e("EventosName","Nombre es : " + name);
                    String nameEvent = name;
                    //Log.e("Eventos", "evento ciudad: " + dataSnapshot.child(name).child("city").getValue());
                    String cityEvent = dataSnapshot.child(name).child("city").getValue().toString();
                    //Log.e("Eventos", "evento id: " + dataSnapshot.child(name).child("id").getValue());
                    int idEvent = Integer.parseInt(dataSnapshot.child(name).child("id").getValue().toString());
                    //Log.e("Eventos", "evento like: " + dataSnapshot.child(name).child("like").getValue());
                    String isBooleanT = dataSnapshot.child(name).child("like").getValue().toString();
                    Boolean booleanEvent;


                    //Log.e("Eventos", "evento picture: " + dataSnapshot.child(name).child("picture").getValue());
                    int pictureEvent = Integer.parseInt(dataSnapshot.child(name).child("picture").getValue().toString());
                    //Log.e("Eventos", "evento timestamp: " + dataSnapshot.child(name).child("timestamp").getValue());
                    String timeEvent = dataSnapshot.child(name).child("timestamp").getValue().toString();
                    //Log.e("Eventos", "evento type: " + dataSnapshot.child(name).child("type").getValue());
                    int typeEvent = Integer.parseInt(dataSnapshot.child(name).child("type").getValue().toString());

                    if (isBooleanT.equals("TRUE")){
                        booleanEvent = Boolean.TRUE;
                        //Log.e("Eventos","El booleano es verdadero");
                        eventosArrayList.add(new eventos(idEvent,nameEvent,typeEvent,cityEvent,timeEvent,pictureEvent,booleanEvent));
                        //Log.e("Eventos","Evento agregado");
                    }else{
                        booleanEvent = Boolean.FALSE;
                        //Log.e("Eventos","El booleano es falso");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        MyAdapter myAdapter2 = new MyAdapter(Constant.FRAGMENT_MISEVENTOS, getContext(), eventosArrayList);

        recyclerView.setAdapter(myAdapter2);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }



}



