package com.example.sistema.mascotas.restApi.adapter;

import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.restApi.ConstantRestApi;
import com.example.sistema.mascotas.restApi.EndpointsApi;
import com.example.sistema.mascotas.restApi.deserialize.FollowsDeserialize;
import com.example.sistema.mascotas.restApi.deserialize.UserDeserialize;
import com.example.sistema.mascotas.restApi.deserialize.MediaDeserialize;
import com.example.sistema.mascotas.restApi.deserialize.SearchDeserialize;
import com.example.sistema.mascotas.restApi.model.FollowsIdUserResponse;
import com.example.sistema.mascotas.restApi.model.FotosLikeResponse;
import com.example.sistema.mascotas.restApi.model.MascotasResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    // Conexión Instragram
    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    // User -> Mascota
    public Gson gsonUserDeserialize(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Mascota.class, new UserDeserialize());
        return gsonBuilder.create();
    }

    // Media -> FotosLike
    public Gson gsonMediaDeserialize(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(FotosLikeResponse.class, new MediaDeserialize());
        return gsonBuilder.create();
    }

    // Search -> Mascota
    public Gson gsonSearchDeserialize(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Mascota.class, new SearchDeserialize());
        return gsonBuilder.create();
    }

    // Follows -> Mascotas
    public Gson gsonFollowsDeserialize(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotasResponse.class, new FollowsDeserialize());
        return gsonBuilder.create();
    }

    public EndpointsApi establecerConexionRestApiServer(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantRestApi.ROOT_URL_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    return retrofit.create(EndpointsApi.class);
    }
}
