package com.example.crudsqlite.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudsqlite.R;
import com.example.crudsqlite.entidades.Precio;

import java.util.ArrayList;

public class ListaPrecioAdapter extends RecyclerView.Adapter<ListaPrecioAdapter.PrecioViewHolder>{

    ArrayList<Precio> listaPrecio;

    public ListaPrecioAdapter(ArrayList<Precio> listaPrecio){
        this.listaPrecio = listaPrecio;
    }

    @NonNull
    @Override
    public PrecioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_producto, null,
                false);
        return new PrecioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPrecioAdapter.PrecioViewHolder holder, int position) {
        holder.viewNombre.setText(listaPrecio.get(position).getNombre());
        holder.viewPrecio.setText(listaPrecio.get(position).getPrecio());
        holder.viewStock.setText(listaPrecio.get(position).getStock());
    }

    @Override
    public int getItemCount() {
       return listaPrecio.size();
    }


    public class PrecioViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewPrecio, viewStock;

        public PrecioViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewPrecio = itemView.findViewById(R.id.viewPrecio);
            viewStock = itemView.findViewById(R.id.viewStock);

        }
    }
}
