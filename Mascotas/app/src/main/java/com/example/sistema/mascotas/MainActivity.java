package com.example.sistema.mascotas;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sistema.mascotas.adapter.PageAdapter;
import com.example.sistema.mascotas.restApi.ConstantRestApi;
import com.example.sistema.mascotas.restApi.EndpointsApi;
import com.example.sistema.mascotas.restApi.adapter.RestApiAdapter;
import com.example.sistema.mascotas.restApi.model.UsuarioResponse;
import com.example.sistema.mascotas.view.CuentaActivityView;
import com.example.sistema.mascotas.view.fragment.ListaFragmentView;
import com.example.sistema.mascotas.view.fragment.PerfilFragmentView;
import com.example.sistema.mascotas.view.FavoritoMascotasView;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar miActionBar;

    ArrayList<Fragment> fragments;
    private RecyclerView rvMascotas;

    private static final String TAG = "Firebase servidor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);
        agregarFragment();
        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ListaFragmentView());
        fragments.add(new PerfilFragmentView());
        return fragments;

    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_lista);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mFavoritos: // Favoritos
                Intent intent = new Intent(this, FavoritoMascotasView.class);
                startActivity(intent);
                break;
            case R.id.mContacto: // Contactos
                Intent iContacto = new Intent(this, ContactoActivity.class);
                startActivity(iContacto);
                break;
            case R.id.mAcercaDe: // Acerca de
                Intent iAcerdaDe = new Intent(this, BioActivity.class);
                startActivity(iAcerdaDe);
                break;
            case R.id.mCuenta: // Configurar cuenta
                Intent iCuenta = new Intent(this, CuentaActivityView.class);
                startActivity(iCuenta);
                finish();
                break;
            case R.id.mRecibirNotificaciones:
                // registrar usuario en la base de datos firebase
                String token = FirebaseInstanceId.getInstance().getToken();
                RestApiAdapter restApiAdapter = new RestApiAdapter();

                EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiServer();
                Call<UsuarioResponse> tokenResponseCall = endpointsApi.setUsuarioDB(token, ConstantRestApi.KEY_USER);
                tokenResponseCall.enqueue(new Callback<UsuarioResponse>() {
                    @Override
                    public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                        UsuarioResponse usuarioResponse = response.body();
                        Log.d(TAG, usuarioResponse.getId().toString());
                        Log.d(TAG, usuarioResponse.getToken().toString());
                        Log.d(TAG, usuarioResponse.getIdUserInstagram().toString());
                    }

                    @Override
                    public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                        Log.e("FALLO LA CONEXION", t.toString());
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
