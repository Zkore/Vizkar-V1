package com.iteso.vizkar_v1.beans;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iteso.vizkar_v1.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private ArrayList<eventos> evento;
    private Context context;
    private int fragment;

    MyAdapter(int fragment, Context context, ArrayList<eventos> evento){
        this.fragment = fragment;
        this.evento = evento;
        this.context = context;
    }

    public MyAdapter() {

    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mEventName;
        TextView mTypeName;
        TextView mDateEvent;
        TextView mCityName;
        RelativeLayout mDetail;
        ImageView mImage;

        ViewHolder(View v){
            super(v);
            mEventName = v.findViewById( R.id.name_of_the_event);
            mTypeName = v.findViewById(R.id.type_of_the_event);
            mDateEvent = v.findViewById(R.id.date_of_the_event);
            mImage = v.findViewById(R.id.event_thumbnail);
            mDetail = v.findViewById(R.id.item_product_layout);
            mCityName = v.findViewById(R.id.city_of_the_event);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.mEventName.setText(evento.get(holder.getAdapterPosition()).getName());
        //holder.mTypeName.setText(evento.get(holder.getAdapterPosition()).getType());
        //holder.mDateEvent.setText(evento.get(holder.getAdapterPosition()).getTimestamp());

    }

    @Override
    public int getItemCount() {
        return 15;
        //return evento.size();
    }
}