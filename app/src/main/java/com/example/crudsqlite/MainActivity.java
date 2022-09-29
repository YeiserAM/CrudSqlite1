package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.crudsqlite.adaptadores.ListaPrecioAdapter;
import com.example.crudsqlite.db.DbFrutas;
import com.example.crudsqlite.db.Dbhelper;
import com.example.crudsqlite.entidades.Precio;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaproducto;
    ArrayList<Precio> listaArrayPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaproducto = findViewById(R.id.listaProductos);
        listaproducto.setLayoutManager(new LinearLayoutManager(this));

        DbFrutas dbFrutas= new DbFrutas(MainActivity.this);

        listaArrayPrecio = new ArrayList<>();

        ListaPrecioAdapter adapter = new ListaPrecioAdapter(dbFrutas.mostrarProductos());
        listaproducto.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);
    }
}