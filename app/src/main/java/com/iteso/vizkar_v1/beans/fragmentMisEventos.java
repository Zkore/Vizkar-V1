package com.iteso.vizkar_v1.beans;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iteso.vizkar_v1.R;


public class fragmentMisEventos extends Fragment {



    public fragmentMisEventos(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_mis_eventos, container, false);

        ImageView imageViewIfNothing = view.findViewById(R.id.contentImage);
        TextView textNothing = view.findViewById(R.id.text_nothingHere);
        Boolean isSomethingHere = Boolean.FALSE;


        if(isSomethingHere == false) {
            imageViewIfNothing.setVisibility(View.VISIBLE);
            textNothing.setText(R.string.myEvents_nothingInHere);
        }else
            textNothing.setText(R.string.nothing);


        return view;
    }
}
