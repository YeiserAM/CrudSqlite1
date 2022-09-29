package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudsqlite.db.DbFrutas;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtPrecio, txtStock;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtStock = findViewById(R.id.txtStock);
        btnGuarda = findViewById(R.id.btnGuardar);



        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                DbFrutas dbFrutas = new DbFrutas(NuevoActivity.this);
                long id = dbFrutas.insertarProductos(txtNombre.getText().toString(),
                        txtPrecio.getText().toString(),
                        txtStock.getText().toString());

                if (id < 0) {
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void limpiar(){
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }
}