package com.iteso.vizkar_v1.beans;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.iteso.vizkar_v1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEventosProximosDef extends Fragment {

    public FragmentEventosProximosDef() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_eventos_proximos_def, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_eventos_proximos_def, container,false);

        ImageView gifContent = view.findViewById(R.id.contentImage);

        //Glide.with(this).load("https://media1.giphy.com/media/1hAZTkpyspqD2OSRva/giphy.gif?cid=3640f6095bceb4ad3369555a637a6873").into(gifContent);

        return view;

    }

}
