package com.iteso.vizkar_v1.beans;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.vizkar_v1.R;
import com.iteso.vizkar_v1.beans.FragmentEventosProximos;
import com.iteso.vizkar_v1.tools.Constant;

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
        LinearLayout viewCard;
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
            viewCard = v.findViewById(R.id.linear_layout_card_to_view);
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

        if(mEventos.getLike() == Boolean.TRUE)
        holder.mLike.setText("Dislike");
        else
        holder.mLike.setText("Like");

        holder.mCityName.setText(mEventos.getCity());
        holder.mTypeName.setText(mEventos.getType());
        holder.mDateEvent.setText(mEventos.getTimestamp());
        holder.mEventName.setText(mEventos.getName());

        switch (mEventos.getPicture()){
            case Constant.TYPE_COORDENADA: //Coordenada
                holder.mImage.setImageResource(R.drawable.coordenada); break;
            case Constant.TYPE_PALNORTE:
                holder.mImage.setImageResource(R.drawable.palnorte); break;
            case Constant.TYPE_UNKNOWS:
                holder.mImage.setImageResource(R.drawable.sad_emoji); break;
        }

        holder.viewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        holder.mLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.e("Like" , ""+mEventos.getLike());
                mEventos.setLike(!(mEventos.getLike()));
                if(mEventos.getLike() == Boolean.TRUE)
                {
                    Toast.makeText(context, "Added to my events " , Toast.LENGTH_SHORT).show();
                    holder.mLike.setText("Dislike");
                    mEventos.setLike(Boolean.TRUE);

                }
                else {
                    Toast.makeText(context, "Removed of my events " , Toast.LENGTH_SHORT).show();
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