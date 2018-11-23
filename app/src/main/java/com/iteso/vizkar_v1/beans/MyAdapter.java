package com.iteso.vizkar_v1.beans;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.beans.FragmentEventosProximos;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<eventos> evento;
    private Context context;
    private int fragment;
    fragmentMisEventos misEventos;

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
        Button mLike;

        ViewHolder(View v){
            super(v);
            mEventName = v.findViewById( R.id.name_of_the_event);
            mTypeName = v.findViewById(R.id.type_of_the_event);
            mDateEvent = v.findViewById(R.id.date_of_the_event);
            mImage = v.findViewById(R.id.event_thumbnail);
            mDetail = v.findViewById(R.id.item_product_layout);
            mCityName = v.findViewById(R.id.city_of_the_event);
            mLike = v.findViewById(R.id.Btn_like_disklike);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final eventos mEventos = evento.get(position);

        if(mEventos.getLike() == Boolean.TRUE);
        holder.mLike.setText("Dislike");
        if (mEventos.getLike() == Boolean.FALSE){
            holder.mLike.setText("Like");
        }

        holder.mCityName.setText(mEventos.getCity());
        holder.mTypeName.setText(mEventos.getType());
        holder.mDateEvent.setText(mEventos.getTimestamp());
        holder.mEventName.setText(mEventos.getName());

        holder.mLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Added to my events " + position + "Like: "+ mEventos.getLike(), Toast.LENGTH_SHORT).show();
                mEventos.setLike(!(mEventos.getLike()));
                if(mEventos.getLike() == Boolean.TRUE);
                {

                    holder.mLike.setText("Dislike");

                }
                if (mEventos.getLike() == Boolean.FALSE){
                    holder.mLike.setText("Like");
                }
                //Toast.makeText(context, "En Adapter" , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return evento.size();
    }
}