package com.example.sistema.mascotas.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.sistema.mascotas.db.BaseDatos;
import com.example.sistema.mascotas.db.ConstantesBaseDatos;

import java.util.ArrayList;

/**
 * Created by Sistema on 02/05/2017.
 */

public class InteractorMascota {
    private static final int LIKE = 1;
    private Context context;

    public InteractorMascota(Context context)
    {
        this.context = context;
    }

    public ArrayList<FotoMascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerMascotas();
    }

    public void insertarUltimaMascota(FotoMascota mascota){
        
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID_FOTO, mascota.getIdFoto() );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID,      mascota.getIdMascota() );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,  mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,    mascota.getFoto());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE,    mascota.getLike());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TIME,    mascota.getTime());
        BaseDatos db = new BaseDatos(context);
        db.InsertarUltimaMascota(contentValues);
    }
}
