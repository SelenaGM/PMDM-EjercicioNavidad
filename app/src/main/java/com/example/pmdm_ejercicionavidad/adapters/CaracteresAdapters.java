package com.example.pmdm_ejercicionavidad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_ejercicionavidad.R;
import com.example.pmdm_ejercicionavidad.modelos.Characters;
import com.example.pmdm_ejercicionavidad.modelos.DataItem;

import java.util.List;

public class CaracteresAdapters extends RecyclerView.Adapter<CaracteresAdapters.CaracterVH> {

    private List<DataItem> objects;
    private int resource;
    private Context context;

    public CaracteresAdapters(List<DataItem> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public CaracteresAdapters.CaracterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View caracterView = LayoutInflater.from(context).inflate(resource,null); //el inflate es null porque no queremos que se enganche a otro, no es hijo de nadie
        caracterView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new CaracterVH(caracterView);
    }

    @Override
    public void onBindViewHolder(@NonNull CaracteresAdapters.CaracterVH holder, int position) {
        DataItem c = objects.get(position);
        holder.lblTitulo.setText(c.getName());

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class CaracterVH  extends RecyclerView.ViewHolder{

        TextView lblTitulo;

        public CaracterVH(@NonNull View itemView) {
            super(itemView);
            lblTitulo = itemView.findViewById(R.id.lblTituloPersonajeCaracterView);
        }
    }
}
