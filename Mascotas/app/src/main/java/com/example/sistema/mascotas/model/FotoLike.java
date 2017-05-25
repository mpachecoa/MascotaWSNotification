package com.example.sistema.mascotas.model;

/**
 * Created by Sistema on 26/04/2017.
 */

public class FotoLike {
    private String id;
    private String foto;
    private int    like;
    private String time;

    public FotoLike() {};

    public FotoLike(String id, String foto, int like, String time) {
        this.id = id;
        this.foto = foto;
        this.like = like;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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