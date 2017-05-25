package com.example.sistema.mascotas.restApi.model;

/**
 * Created by Sistema on 21/05/2017.
 */

public class UsuarioResponse {
    private String id;
    private String token;
    private String idUserInstagram;

    public UsuarioResponse(String id, String token, String idUserInstagram) {
        this.id = id;
        this.token = token;
        this.idUserInstagram = idUserInstagram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdUserInstagram() {
        return idUserInstagram;
    }

    public void setIdUserInstagram(String idUserInstagram) {
        this.idUserInstagram = idUserInstagram;
    }
}
