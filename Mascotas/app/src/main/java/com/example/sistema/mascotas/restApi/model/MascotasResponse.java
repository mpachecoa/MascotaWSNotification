package com.example.sistema.mascotas.restApi.model;

import com.example.sistema.mascotas.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Sistema on 12/05/2017.
 */

public class MascotasResponse {
    ArrayList<Mascota> mascotas = new ArrayList<>();

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
