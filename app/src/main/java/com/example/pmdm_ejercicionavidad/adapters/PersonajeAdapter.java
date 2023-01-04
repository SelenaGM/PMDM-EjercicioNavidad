package com.example.pmdm_ejercicionavidad.adapters;

import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_ejercicionavidad.R;
import com.example.pmdm_ejercicionavidad.modelos.DataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeVH> {

    private List<DataItem> objects;
    private int resource;
    private Context context;

    public PersonajeAdapter(List<DataItem> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonajeAdapter.PersonajeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PersonajeVH(LayoutInflater.from(context).inflate(resource,null));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeAdapter.PersonajeVH holder, int position) {
        DataItem c = objects.get(position);
        holder.lblInfo.setText(c.getName());
        Picasso.get()
                .load(c.getImageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class PersonajeVH extends RecyclerView.ViewHolder{

        ImageView imgFoto;
        TextView lblInfo;

        public PersonajeVH(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgImagenPersonajeView);
            lblInfo = itemView.findViewById(R.id.lblInfoPersonajeView);
        }
    }
}
