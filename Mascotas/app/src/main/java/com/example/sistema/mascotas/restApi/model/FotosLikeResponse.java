package com.example.sistema.mascotas.restApi.model;

import com.example.sistema.mascotas.model.FotoLike;

import java.util.ArrayList;

/**
 * Created by Sistema on 12/05/2017.
 */

public class FotosLikeResponse {
    ArrayList<FotoLike> fotosLike = new ArrayList<>();

    public ArrayList<FotoLike> getFotosLike() {
        return fotosLike;
    }

    public void setFotosLike(ArrayList<FotoLike> fotosLike) {
        this.fotosLike = fotosLike;
    }
}
