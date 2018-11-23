package com.iteso.vizkar_v1.beans;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class AppPreferences {

    public static final ArrayList<eventos> eventosArrayList  = new ArrayList<>();
    SharedPreferences eventosEscogidos;

    public AppPreferences (Context context){
        this.eventosEscogidos = context.getSharedPreferences("Eventos",Context.MODE_PRIVATE );
    }

}
