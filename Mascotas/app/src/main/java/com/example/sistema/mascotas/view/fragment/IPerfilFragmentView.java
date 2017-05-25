package com.example.sistema.mascotas.view.fragment;

import com.example.sistema.mascotas.adapter.FotoLikeAdaptador;
import com.example.sistema.mascotas.model.FotoLike;
import com.example.sistema.mascotas.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Sistema on 13/05/2017.
 */

public interface IPerfilFragmentView {

    public void iniciarPerfilMascota(Mascota mascota);

    public void generarLinearLayoutVertical();

    public FotoLikeAdaptador crearAdaptador(ArrayList<FotoLike> fotosLike);

    public void inicializarAdaptadorRV(FotoLikeAdaptador adaptador);
}
