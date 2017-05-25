package com.example.sistema.mascotas.view;

import com.example.sistema.mascotas.adapter.FavoritoAdaptador;
import com.example.sistema.mascotas.model.FotoMascota;

import java.util.ArrayList;

/**
 * Created by Sistema on 02/05/2017.
 */

public interface IFavoritoMascotasView {

    public void generarLinearLayoutVertical();

    public FavoritoAdaptador crearAdaptador(ArrayList<FotoMascota> mascotas);

    public void inicializarAdaptadorRV(FavoritoAdaptador adaptador);
}
