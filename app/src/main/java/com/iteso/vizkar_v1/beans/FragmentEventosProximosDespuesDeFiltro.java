package com.iteso.vizkar_v1.beans;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.iteso.vizkar_v1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEventosProximosDespuesDeFiltro extends Fragment {

    public FragmentEventosProximosDespuesDeFiltro() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_eventos_proximos_def, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_eventos_proximos_def, container,false);

        ImageView imageViewIfNothing = view.findViewById(R.id.contentImage);

        //imageViewIfNothing.setVisibility(View.VISIBLE);



        return view;

    }

}
