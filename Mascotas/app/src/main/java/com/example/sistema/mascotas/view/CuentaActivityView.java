package com.example.sistema.mascotas.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.example.sistema.mascotas.MainActivity;
import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.presenter.CuentaActivityPresenter;

public class CuentaActivityView extends AppCompatActivity implements ICuentaActivityView{

    TextInputEditText tietCuenta;
    CuentaActivityPresenter cuentaActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        tietCuenta = (TextInputEditText) findViewById(R.id.tietCuentaInstagram);

        cuentaActivityPresenter = new CuentaActivityPresenter(this, getBaseContext());
    }

    public void guardarCuenta ( View v) {
        cuentaActivityPresenter.obtenerdatos(tietCuenta.getText().toString());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            goMainActivity();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void goMainActivity() {
        Intent intent = new Intent(CuentaActivityView.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
