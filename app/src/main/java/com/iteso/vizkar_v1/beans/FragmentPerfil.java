package com.iteso.vizkar_v1.beans;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.activityLoginScreen;

import java.util.Locale;
import java.util.zip.Inflater;

import static android.content.Context.LOCATION_SERVICE;


public class FragmentPerfil extends Fragment {
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    EditText cityET;
    EditText Name, Email;
    public FragmentPerfil() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        View view = inflater.inflate(R.layout.fragment_fragment_perfil,container,false);
        Name = view.findViewById(R.id.EditTextName);
        Email = view.findViewById(R.id.EditTextMail);
        Name.setText(currentUser.getDisplayName());
        Email.setText(currentUser.getEmail());
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
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), activityLoginScreen.class);
        startActivity(intent);
        getActivity().onBackPressed();
        FragmentEventosProximos.isLoadedLogout = true;

    }

}
