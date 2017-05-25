package com.example.sistema.mascotas.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.adapter.FotoLikeAdaptador;
import com.example.sistema.mascotas.adapter.MascotaAdaptador;
import com.example.sistema.mascotas.model.FotoLike;
import com.example.sistema.mascotas.model.FotoMascota;
import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.presenter.fragment.PerfilFragmentPresenter;
import com.example.sistema.mascotas.restApi.ConstantRestApi;
import com.example.sistema.mascotas.restApi.EndpointsApi;
import com.example.sistema.mascotas.restApi.adapter.RestApiAdapter;
import com.example.sistema.mascotas.restApi.model.FotosLikeResponse;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragmentView extends Fragment implements IPerfilFragmentView {

    private ImageView imgFotoPerfil;
    private TextView tvNombre;
    private RecyclerView rvFotosLike;
    private PerfilFragmentPresenter perfilFragmentPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imgFotoPerfil = (ImageView) getActivity().findViewById(R.id.imgFotoPerfil);
        tvNombre = (TextView) getActivity().findViewById(R.id.tvNombre);

        rvFotosLike = (RecyclerView) getActivity().findViewById(R.id.rvFotosLike);

        perfilFragmentPresenter = new PerfilFragmentPresenter(this, getActivity());

    }

    @Override
    public void iniciarPerfilMascota(Mascota mascota) {

        Picasso.with(getActivity())
                .load(mascota.getFotoPerfil())
                .placeholder(R.drawable.ic_dog_bone_50)
                .into(imgFotoPerfil);

        tvNombre.setText(String.valueOf(mascota.getNombre()));
    }

    @Override
    public void generarLinearLayoutVertical() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvFotosLike.setLayoutManager(glm);
    }

    @Override
    public FotoLikeAdaptador crearAdaptador(ArrayList<FotoLike> fotosLike) {
        FotoLikeAdaptador adaptador = new FotoLikeAdaptador(fotosLike, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FotoLikeAdaptador adaptador) {
        rvFotosLike.setAdapter(adaptador);

    }
}
