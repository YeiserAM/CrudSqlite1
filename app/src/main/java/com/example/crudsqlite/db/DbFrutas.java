package com.example.crudsqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.crudsqlite.entidades.Precio;

import java.util.ArrayList;

public class DbFrutas extends Dbhelper {

    Context context;

    public DbFrutas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProductos(String nombre, String precio, String stock){

        long id = 0;

        try {
            Dbhelper dbhelper = new Dbhelper(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("precio", precio);
            values.put("stock", stock);

            id = db.insert(TABLE_FRUTAS, null, values);
        } catch (Exception ex){
            ex.toString();
        }

        return id;
    }

    public ArrayList<Precio> mostrarProductos(){

        Dbhelper dbhelper = new Dbhelper(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ArrayList<Precio> listaproducto = new ArrayList<>();
        Precio precio = null;
        Cursor cursorPrecio = null;

        cursorPrecio = db.rawQuery("SELECT * FROM"+ TABLE_FRUTAS, null);

        if (cursorPrecio.moveToFirst()){
            do {
                precio = new Precio();
                precio.setId(cursorPrecio.getInt(0));
                precio.setNombre(cursorPrecio.getString(1));
                precio.setPrecio(cursorPrecio.getString(2));
                precio.setStock(cursorPrecio.getString(3));
                listaproducto.add(precio);
            }while (cursorPrecio.moveToNext());
        }
        cursorPrecio.close();
        return listaproducto;
    }

}
