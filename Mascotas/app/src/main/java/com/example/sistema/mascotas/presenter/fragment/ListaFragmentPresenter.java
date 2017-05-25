package com.example.sistema.mascotas.presenter.fragment;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sistema.mascotas.model.FotoLike;
import com.example.sistema.mascotas.model.FotoMascota;
import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.restApi.EndpointsApi;
import com.example.sistema.mascotas.restApi.adapter.RestApiAdapter;
import com.example.sistema.mascotas.restApi.model.FotosLikeResponse;
import com.example.sistema.mascotas.restApi.model.MascotasResponse;
import com.example.sistema.mascotas.view.fragment.IListaFragmentView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sistema on 13/05/2017.
 */

public class ListaFragmentPresenter implements IListaFragmentPresenter {

    IListaFragmentView iListaFragmentView;
    Context context;
    private ArrayList<FotoMascota> timeline = new ArrayList<>();
    ArrayList<Mascota> mascotas = new ArrayList<>();
    int countFollows = 0;

    public ListaFragmentPresenter(IListaFragmentView iListaFragmentView, Context context) {
        this.iListaFragmentView = iListaFragmentView;
        this.context = context;
        getTimeline();
    }

    @Override
    public void getTimeline(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();

        Gson gsonFollow = restApiAdapter.gsonFollowsDeserialize();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonFollow);
        Call<MascotasResponse> mascotasResponseCall = endpointsApi.getFollowsUser();
        mascotasResponseCall.enqueue(new Callback<MascotasResponse>() {
            @Override
            public void onResponse(Call<MascotasResponse> call, Response<MascotasResponse> response) {

                MascotasResponse mascotasResponse = response.body();

                mascotas = mascotasResponse.getMascotas();

                if ((mascotas.size() == 0)) {
                    Toast.makeText(context, "No existe usuarios seguidos.", Toast.LENGTH_LONG).show();
                    Log.d("FOLLOW_USER", "Usuario no existe");

                } else if (mascotas.size() > 0) {
                    Log.d("SINCRO", "1");
                    getMediaTimeline();
                    Log.d("SINCRO", "2");
                } else {

                }
            }

            @Override
            public void onFailure(Call<MascotasResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());

            }
        });

    }


    public void getMediaTimeline() {
        Log.d("SINCRO", "1.1");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonFollow = restApiAdapter.gsonMediaDeserialize();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonFollow);
        for (final Mascota mascota: mascotas) {

            Call<FotosLikeResponse> fotosLikeResponseCall = endpointsApi.getRecentMedia(mascota.getId());

            fotosLikeResponseCall.enqueue(new Callback<FotosLikeResponse>() {
                @Override
                public void onResponse(Call<FotosLikeResponse> call, Response<FotosLikeResponse> response) {

                    FotosLikeResponse fotosLikeResponse = response.body();
                    ArrayList<FotoLike> fotosLike = fotosLikeResponse.getFotosLike();
                    Log.d("SINCRO", "1.1.1");

                    for (FotoLike fotolike : fotosLike) {

                        timeline.add(new FotoMascota(fotolike.getId(),
                                                     mascota.getId(),
                                                     mascota.getNombre(),
                                                     fotolike.getFoto(),
                                                     fotolike.getLike(),
                                                     fotolike.getTime()
                        ));
                    }
                    ++countFollows;
                    if (countFollows == mascotas.size()) {

                        Collections.sort(timeline, new Comparator<FotoMascota>() {
                            @Override
                            public int compare(FotoMascota m1, FotoMascota m2) {
                                return new Long(m2.getTime()).compareTo(new Long(m1.getTime()));
                            }
                        });

                        mostrarTimeLineRV();

                    }
                }

                @Override
                public void onFailure(Call<FotosLikeResponse> call, Throwable t) {
                    Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                    Log.e("FALLO LA CONEXION", t.toString());

                }
            });
        }
    }

    @Override
    public void mostrarTimeLineRV() {
        iListaFragmentView.inicializarAdaptadorRV(iListaFragmentView.crearAdaptador(timeline));
        iListaFragmentView.generarLinearLayoutVertical();
    }
}
