package com.iteso.vizkar_v1.beans;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.iteso.vizkar_v1.R;

import java.util.Locale;

import static android.content.Context.LOCATION_SERVICE;


public class FragmentPerfil extends Fragment {

    EditText cityET;


    public FragmentPerfil() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //return inflater.inflate(R.layout.fragment_fragment_perfil, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_perfil,container,false);

        /*
        EditText cityET = view.findViewById(R.id.EditTextCity);
        Button getLocation = view.findViewById(R.id.locationBtn);

        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Buscando Ciudad", Toast.LENGTH_SHORT).show();
                //cityET.setText("Guadalajara");
            }
        });

        */


        return view;
    }
/*
    public void doSomething(View view){

        switch(view.getId()){
            case R.id.TextView_City:
                Toast.makeText(getContext(), "Buscando Ciudad", Toast.LENGTH_SHORT).show();
                 cityET = view.findViewById(R.id.EditTextCity);
                 cityET.setText("Guadalajara");
                break;
        }

    }
    */

}
