package com.example.sistema.mascotas.presenter.fragment;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.restApi.ConstantRestApi;
import com.example.sistema.mascotas.restApi.EndpointsApi;
import com.example.sistema.mascotas.restApi.adapter.RestApiAdapter;
import com.example.sistema.mascotas.restApi.model.FotosLikeResponse;
import com.example.sistema.mascotas.view.fragment.IPerfilFragmentView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sistema on 13/05/2017.
 */

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    IPerfilFragmentView iPerfilFragmentView;
    Context context;
    Mascota mascota = new Mascota();


    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;
        getMascota();
    }

    @Override
    public void getMascota() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonUser = restApiAdapter.gsonUserDeserialize();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonUser);

        Call<Mascota> mascotaResponseCall = endpointsApi.getUser(ConstantRestApi.KEY_USER);

        mascotaResponseCall.enqueue(new Callback<Mascota>() {
            @Override
            public void onResponse(Call<Mascota> call, Response<Mascota> response) {
                //mascota = response.body();
                mascota = response.body();
                getFotoLike();
            }

            @Override
            public void onFailure(Call<Mascota> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }


    public void getFotoLike() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();

        Gson gsonMediaRecent = restApiAdapter.gsonMediaDeserialize();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<FotosLikeResponse> mascotaResponseCall = endpointsApi.getRecentMedia(mascota.getId());
        mascotaResponseCall.enqueue(new Callback<FotosLikeResponse>() {
            @Override
            public void onResponse(Call<FotosLikeResponse> call, Response<FotosLikeResponse> response) {
                //mascota = response.body();
                mascota.setFotos(response.body().getFotosLike());
                mostrarMascota();
            }

            @Override
            public void onFailure(Call<FotosLikeResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }

    @Override
    public void mostrarMascota() {
        iPerfilFragmentView.iniciarPerfilMascota(mascota);
        iPerfilFragmentView.inicializarAdaptadorRV(iPerfilFragmentView.crearAdaptador(mascota.getFotos()));
        iPerfilFragmentView.generarLinearLayoutVertical();

    }
}
