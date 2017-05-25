package com.example.sistema.mascotas.model;

import java.util.ArrayList;

/**
 * Created by Sistema on 21/04/2017.
 */

public class Mascota {
    private String id;
    private String nombre;
    private String fotoPerfil;
    private ArrayList<FotoLike> fotos = new ArrayList<>();

    public Mascota() {
    }

    public Mascota(String id, String nombre, String fotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
    }

    public Mascota(String id, String nombre, String fotoPerfil, ArrayList<FotoLike> fotos) {
        this.id = id;
        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.fotos = fotos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public ArrayList<FotoLike> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<FotoLike> fotos) {
        this.fotos = fotos;
    }
}
