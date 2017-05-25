package com.example.sistema.mascotas;

import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity {

    TextInputEditText tietCorreoEnvio;
    TextInputEditText tietContraseñaEnvio;
    TextInputEditText tietNombre;
    TextInputEditText tietCorreoDestino;
    TextInputEditText tietMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        tietCorreoEnvio = (TextInputEditText) findViewById(R.id.tietCorreoEnvio);
        tietContraseñaEnvio = (TextInputEditText) findViewById(R.id.tietContraseñaEnvío);

        tietNombre = (TextInputEditText) findViewById(R.id.tietNombre);
        tietCorreoDestino = (TextInputEditText) findViewById(R.id.tietCorreoDestino);
        tietMensaje = (TextInputEditText) findViewById(R.id.tietMensaje);
    }

    public void enviarCorreo (View v) {


        Mail m = new Mail(tietCorreoEnvio.getText().toString(), tietContraseñaEnvio.getText().toString());
        String[] toArr = {tietCorreoDestino.getText().toString()};
        m.setTo(toArr);
        m.setFrom(tietCorreoEnvio.getText().toString());
        m.setSubject("Aplicativo Movil Mascota");
        m.setBody(tietNombre.getText().toString() +", \n " + tietMensaje.getText().toString());
        try {
            //m.addAttachment("/sdcard/filelocation");

            if(m.send()) {
                Toast.makeText(this, "Correo enviado safisfactoriamente.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Correo no fue enviado.", Toast.LENGTH_LONG).show();
            }
        } catch(Exception e) {
            Toast.makeText(this, "Hubo algun problema enviando el correo.", Toast.LENGTH_LONG).show();
            Log.e("SendMail", "Correo no enviado", e);
        }


    }
}

