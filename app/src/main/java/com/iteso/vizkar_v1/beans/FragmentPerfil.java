package com.iteso.vizkar_v1.beans;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;

import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.activityLoginScreen;

import java.util.Locale;
import java.util.zip.Inflater;

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


        final EditText cityET = view.findViewById(R.id.EditTextCity);
        ImageButton getLocation = view.findViewById(R.id.locationBtn);
        final Button logOut = view.findViewById(R.id.logOutbtn);


        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Buscando Ciudad", Toast.LENGTH_SHORT).show();
                //(EditText) view.findViewById(R.id.EditTextCity).setText
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cityET.setText("Guadalajara");
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });

        return view;
    }

    private void logOut(){
        Intent intent = new Intent(getActivity(), activityLoginScreen.class);
        startActivity(intent);
        getActivity().onBackPressed();

    }

}
