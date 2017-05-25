package com.example.sistema.mascotas.restApi.deserialize;

import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.restApi.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class UserDeserialize implements JsonDeserializer<Mascota> {

    @Override
    public Mascota deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        JsonObject userJson = json.getAsJsonObject().getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY);

        String id           = userJson.get(JsonKeys.USER_ID).getAsString();
        String nombre       = userJson.get(JsonKeys.USER_FULLNAME).getAsString();
        String fotoPerfil   = userJson.get(JsonKeys.USER_PROFILE_PICTURE).getAsString();

        return (new Mascota(id, nombre, fotoPerfil));
    }
}
