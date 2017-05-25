package com.example.sistema.mascotas.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.adapter.MascotaAdaptador;
import com.example.sistema.mascotas.model.FotoMascota;
import com.example.sistema.mascotas.presenter.fragment.ListaFragmentPresenter;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragmentView extends Fragment implements IListaFragmentView {

    private RecyclerView rvMascotas;
    ListaFragmentPresenter listaFragmentPresenter;

    public ListaFragmentView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rvMascotas = (RecyclerView) getActivity().findViewById(R.id.rvMascotas);
        listaFragmentPresenter = new ListaFragmentPresenter(this, getActivity());
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<FotoMascota> timeline) {
        MascotaAdaptador adaptador = new MascotaAdaptador(timeline, getActivity() );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
