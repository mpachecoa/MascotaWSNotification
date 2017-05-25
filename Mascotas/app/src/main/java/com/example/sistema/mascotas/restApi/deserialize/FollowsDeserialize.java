package com.example.sistema.mascotas.restApi.deserialize;

import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.restApi.JsonKeys;
import com.example.sistema.mascotas.restApi.model.MascotasResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Sistema on 11/05/2017.
 */

public class FollowsDeserialize implements JsonDeserializer<MascotasResponse> {
    @Override
    public MascotasResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();

        JsonArray followsResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        return deserializeFollowsJson(followsResponseData);
    }

    private MascotasResponse deserializeFollowsJson(JsonArray followsResponseData){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (int i = 0; i < followsResponseData.size() ; i++) {
            JsonObject userJson = followsResponseData.get(i).getAsJsonObject();
            String id           = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombre       = userJson.get(JsonKeys.USER_FULLNAME).getAsString();
            String fotoPerfil   = userJson.get(JsonKeys.USER_PROFILE_PICTURE).getAsString();
            mascotas.add(new Mascota(id, nombre, fotoPerfil));
        }

        MascotasResponse mascotasResponse = new MascotasResponse();
        mascotasResponse.setMascotas(mascotas);

        return (mascotasResponse);
    }
}
