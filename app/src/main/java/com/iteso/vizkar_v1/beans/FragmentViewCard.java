package com.iteso.vizkar_v1.beans;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.vizkar_v1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewCard extends Fragment {


    public FragmentViewCard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment_fragment_view_card, container, false);
        Log.e("FragmentViewCard","Si carga el inflate");
        return inflater.inflate(R.layout.fragment_fragment_view_card, container, false);
    }

}
