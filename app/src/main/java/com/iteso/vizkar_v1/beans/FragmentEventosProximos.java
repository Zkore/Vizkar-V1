package com.iteso.vizkar_v1.beans;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iteso.vizkar_v1.ActivityViewImage;
import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.tools.Constant;

import java.util.ArrayList;

import static com.iteso.vizkar_v1.tools.Constant.TYPE_MUSICA;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentEventosProximos extends Fragment {

    public static  ArrayList<eventos> eventosArrayList  = new ArrayList<>();
    public static  Boolean isLoaded = false;
    public static  Boolean isLoadedLogout = false;

    DatabaseReference firebaseName = FirebaseDatabase.getInstance().getReference().child("NombreDeEventos");

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
        ImageButton refresh1 = view.findViewById(R.id.refresh_UPCOMING);

        photoView = view.findViewById(R.id.photo_view);

        recyclerView = view.findViewById(R.id.recycler_view_eventos_proximos);

        refresh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction refreshFragment = getFragmentManager().beginTransaction();
                refreshFragment.detach(FragmentEventosProximos.this).attach(FragmentEventosProximos.this).commit();
                //Log.e("Fragment","Detach & atached");
            }
        });

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

        eventosArrayList.add(new eventos(1,"Coordenada",1,"Guadalajara","27 Junio",1,Boolean.TRUE));
        verImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openZoomImage();
            }
        });

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
                    Boolean booleanEvent ;
                    String isBooleanT = dataSnapshot.child(name).child("like").getValue().toString();
                    //Log.e("Eventos", "evento picture: " + dataSnapshot.child(name).child("picture").getValue());
                    int pictureEvent = Integer.parseInt(dataSnapshot.child(name).child("picture").getValue().toString());
                    //Log.e("Eventos", "evento timestamp: " + dataSnapshot.child(name).child("timestamp").getValue());
                    String timeEvent = dataSnapshot.child(name).child("timestamp").getValue().toString();
                    //Log.e("Eventos", "evento type: " + dataSnapshot.child(name).child("type").getValue());
                    int typeEvent = Integer.parseInt(dataSnapshot.child(name).child("type").getValue().toString());

                    if (isBooleanT.equals("TRUE")){
                        booleanEvent = Boolean.TRUE;
                        //Log.e("Eventos","El booleano es verdadero");
                        //Log.e("Eventos","Evento agregado");
                    }else{
                        booleanEvent = Boolean.FALSE;
                        //Log.e("Eventos","El booleano es falso");
                    }

                    eventosArrayList.add(new eventos(idEvent,nameEvent,typeEvent,cityEvent,timeEvent,pictureEvent,booleanEvent));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myAdapter1 = new MyAdapter(Constant.FRAGMENT_EVENTOSPROXIMOS, getContext(), eventosArrayList);
         //myAdapter1 = new MyAdapter(Constant.FRAGMENT_MISEVENTOS, getContext(), eventosArrayList);


        recyclerView.setAdapter(myAdapter1);

    }

    public void openZoomImage(){
        Log.e("openZoomImage","Es casteado");
        Intent intent = new Intent(getActivity() , ActivityViewImage.class);
        startActivity(intent);
    }



}
