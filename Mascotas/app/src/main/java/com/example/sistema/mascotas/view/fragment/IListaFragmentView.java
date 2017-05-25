package com.example.sistema.mascotas.view.fragment;

import com.example.sistema.mascotas.adapter.MascotaAdaptador;
import com.example.sistema.mascotas.model.FotoMascota;
import com.example.sistema.mascotas.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Sistema on 13/05/2017.
 */

public interface IListaFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<FotoMascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
