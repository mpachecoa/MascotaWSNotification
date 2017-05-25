package com.example.sistema.mascotas.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.adapter.FavoritoAdaptador;
import com.example.sistema.mascotas.model.FotoMascota;
import com.example.sistema.mascotas.presenter.FavoritoMascotasPresenter;

import java.util.ArrayList;

public class FavoritoMascotasView extends AppCompatActivity implements IFavoritoMascotasView {

    ArrayList<FotoMascota> mascotas;
    private RecyclerView rvFavoritoMascotas;
    FavoritoMascotasPresenter favoritoMascotasPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito_mascotas);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        rvFavoritoMascotas = (RecyclerView) findViewById(R.id.rvFavoritoMascotas);

        favoritoMascotasPresenter = new FavoritoMascotasPresenter(this, this.getBaseContext());

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavoritoMascotas.setLayoutManager(llm);
    }

    @Override
    public FavoritoAdaptador crearAdaptador(ArrayList<FotoMascota> mascotas) {
        FavoritoAdaptador adaptador = new FavoritoAdaptador(mascotas, this  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FavoritoAdaptador adaptador) {
        rvFavoritoMascotas.setAdapter(adaptador);
    }
}
