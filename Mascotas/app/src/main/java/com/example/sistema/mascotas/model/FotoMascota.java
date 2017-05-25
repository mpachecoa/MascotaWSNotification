package com.example.sistema.mascotas.model;

import java.util.ArrayList;

/**
 * Created by Sistema on 21/04/2017.
 */

public class FotoMascota {
    private String idFoto;
    private String idMascota;
    private String nombre;
    private String foto;
    private int    like;
    private String time;

    public FotoMascota() {
    }

    public FotoMascota(String idFoto, String idMascota, String nombre, String foto, int like, String time) {
        this.idFoto = idFoto;
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.foto = foto;
        this.like = like;
        this.time = time;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
