package com.example.sistema.mascotas.restApi.deserialize;

import android.util.Log;

import com.example.sistema.mascotas.model.FotoLike;
import com.example.sistema.mascotas.restApi.JsonKeys;
import com.example.sistema.mascotas.restApi.model.FotosLikeResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MediaDeserialize implements JsonDeserializer<FotosLikeResponse> {

    @Override
    public FotosLikeResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        FotosLikeResponse fotosLikeResponse;

        JsonArray fotosLikeResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        fotosLikeResponse = deserializeFotoLikeJson(fotosLikeResponseData);

        return fotosLikeResponse;
    }

    private FotosLikeResponse deserializeFotoLikeJson(JsonArray mascotaResponseData){

        ArrayList<FotoLike> fotosLike = new ArrayList<>();
        //Log.d("SINCRO", "1.1");
        for (int i = 0; i < mascotaResponseData.size() ; i++) {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

            String id    = mascotaResponseDataObject.get(JsonKeys.IMAGE_ID).getAsString();
            String time  = mascotaResponseDataObject.get(JsonKeys.IMAGE_TIME).getAsString();;

            JsonObject imageJson            = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String foto                  = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int like = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            FotoLike fotoLike = new FotoLike(id, foto, like, time);
            fotosLike.add(fotoLike);
        }

        FotosLikeResponse fotosLikeResponse = new FotosLikeResponse();
        fotosLikeResponse.setFotosLike(fotosLike);
        return fotosLikeResponse;
    }
}
