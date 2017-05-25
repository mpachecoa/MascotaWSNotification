package com.example.sistema.mascotas.restApi;


public final class ConstantRestApi {



    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "5414559434.a5e0d4b.f4222b456df04826a5b53f160e76efe8";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_USER = "users/{user-id}/";

    public static String KEY_USER = "5414559434";

    // user-self
    //https://api.instagram.com/v1/users/self/?access_token=ACCESS-TOKEN
    public static final String KEY_GET_USER_SELF = "users/self/";
    public static final String URL_GET_USER_SELF = KEY_GET_USER_SELF + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //Seguidos
    //https://api.instagram.com/v1/users/self/follows?access_token=5414559434.a5e0d4b.f4222b456df04826a5b53f160e76efe8
    public static final String KEY_GET_FOLLOWS_USER = "users/self/follows/";
    public static final String URL_GET_FOLLOWS_USER = KEY_GET_FOLLOWS_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    // user
    // https://api.instagram.com/v1/users/{user-id}/?access_token=ACCESS-TOKEN
    public static final String URL_GET_USER = KEY_GET_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    // fotos - media
    // https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN
    // https://api.instagram.com/v1/users/5414559434/media/recent/?access_token=5414559434.a5e0d4b.f4222b456df04826a5b53f160e76efe8
    public static final String KEY_GET_RECENT_MEDIA_USER = KEY_GET_USER + "media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


    // Search
    //https://api.instagram.com/v1/users/search?q=mipache2001&access_token=5414559434.a5e0d4b.f4222b456df04826a5b53f160e76efe8
    public static final String KEY_SEARCH_USER = "users/search";
    public static final String URL_SEARCH_USER = KEY_SEARCH_USER;


    public static final String ROOT_URL_SERVER = "https://safe-gorge-68897.herokuapp.com/";
    public static final String URL_SET_TOKEN = "registrar-usuario";
}
