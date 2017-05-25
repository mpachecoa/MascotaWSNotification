package com.example.sistema.mascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.model.FotoLike;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sistema on 26/04/2017.
 */

public class FotoLikeAdaptador extends RecyclerView.Adapter<FotoLikeAdaptador.FotoLikeViewHolder> {

    ArrayList<FotoLike> fotosLike;
    Activity activity;

    public FotoLikeAdaptador(ArrayList<FotoLike> fotosLike, Activity activity) {
        this.fotosLike = fotosLike;
        this.activity = activity;
    }

    @Override
    public FotoLikeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_perfil, parent, false);
        return new FotoLikeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoLikeViewHolder holder, final int position) {
        final FotoLike fotoLike = fotosLike.get(position);

        Picasso.with(activity)
                .load(fotoLike.getFoto())
                .placeholder(R.drawable.ic_dog_footprint_48)
                .into(holder.imgFotoCV);

        holder.tvFavoritoCV.setText(String.valueOf(fotoLike.getLike()));
    }

    @Override
    public int getItemCount() {
        return fotosLike.size();
    }

    public static class FotoLikeViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView  tvFavoritoCV;

        public FotoLikeViewHolder(View itemView) {
            super(itemView);
            imgFotoCV    = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvFavoritoCV = (TextView)  itemView.findViewById(R.id.tvFavoritoCV);
        }
    }
}
