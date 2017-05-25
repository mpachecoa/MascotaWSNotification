package com.example.sistema.mascotas.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.restApi.ConstantRestApi;
import com.example.sistema.mascotas.restApi.EndpointsApi;
import com.example.sistema.mascotas.restApi.adapter.RestApiAdapter;
import com.example.sistema.mascotas.view.ICuentaActivityView;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sistema on 11/05/2017.
 */

public class CuentaActivityPresenter implements ICuentaActivityPresenter{

    private ICuentaActivityView iCuentaActivityView;
    private Context context;

    public CuentaActivityPresenter(ICuentaActivityView iCuentaActivityView, Context context) {
        this.context = context;
        this.iCuentaActivityView = iCuentaActivityView;
    }

    @Override
    public void obtenerdatos(String user_id) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();

        Gson gsonSearch = restApiAdapter.gsonSearchDeserialize();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonSearch);

        Call<Mascota> mascotaResponseCall = endpointsApi.getSearchUser( user_id, ConstantRestApi.ACCESS_TOKEN );

        mascotaResponseCall.enqueue(new Callback<Mascota>() {
            @Override
            public void onResponse(Call<Mascota> call, Response<Mascota> response) {
                Mascota mascota = response.body();
                if (!(mascota.getId() == null)) {
                    ConstantRestApi.KEY_USER = mascota.getId();
                    Log.d("KEY_USER", ConstantRestApi.KEY_USER);
                    Toast.makeText(context, "Usuario " + mascota.getNombre() + " existe", Toast.LENGTH_LONG).show();
                    iCuentaActivityView.goMainActivity();
                } else {
                    Toast.makeText(context, "Usuario no existe", Toast.LENGTH_LONG).show();
                    Log.d("KEY_USER", "Usuario no existe");
                }
            }
            @Override
            public void onFailure(Call<Mascota> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }
}
