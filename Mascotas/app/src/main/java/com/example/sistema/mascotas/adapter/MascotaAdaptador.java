package com.example.sistema.mascotas.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.model.FotoMascota;
import com.example.sistema.mascotas.model.InteractorMascota;
import com.example.sistema.mascotas.model.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sistema on 21/04/2017.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<FotoMascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<FotoMascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
                                 final FotoMascota mascota = mascotas.get(position);


        Picasso.with(activity)
                .load(mascota.getFoto())
                .placeholder(R.drawable.ic_dog_footprint_48)
                .into(holder.imgFotoCV);

        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvFavoritoCV.setText(String.valueOf(mascota.getLike()));


        holder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InteractorMascota interactorMascota = new InteractorMascota(activity);

                interactorMascota.insertarUltimaMascota(mascota);
                mascota.setLike(mascota.getLike() + 1);
                mascotas.set(position, mascota);
                holder.tvFavoritoCV.setText(String.valueOf(mascota.getLike()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView   imgFotoCV;
        private ImageButton btnLikeCV;
        private TextView    tvNombreCV;
        private TextView    tvFavoritoCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV    = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            btnLikeCV    = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            tvNombreCV   = (TextView)  itemView.findViewById(R.id.tvNombreCV);
            tvFavoritoCV = (TextView)  itemView.findViewById(R.id.tvFavoritoCV);
        }
    }

}
