package com.example.sistema.mascotas.restApi.deserialize;

import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.restApi.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class SearchDeserialize implements JsonDeserializer<Mascota> {

    @Override
    public Mascota deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        return deserializeSearchJson(mascotaResponseData);
    }

    private Mascota deserializeSearchJson(JsonArray mascotaResponseData){

        Mascota mascota = new Mascota();

        for (int i = 0; i < mascotaResponseData.size() ; i++) {
            JsonObject userJson = mascotaResponseData.get(i).getAsJsonObject();
            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombre = userJson.get(JsonKeys.USER_FULLNAME).getAsString();
            String foto = userJson.get(JsonKeys.USER_PROFILE_PICTURE).getAsString();
            mascota.setId(id);
            mascota.setNombre(nombre);
            mascota.setFotoPerfil(foto);
        }
        return mascota;
    }








}
