package com.example.pmdm_ejercicionavidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pmdm_ejercicionavidad.adapters.PersonajeAdapter;
import com.example.pmdm_ejercicionavidad.conexiones.ApiConexiones;
import com.example.pmdm_ejercicionavidad.conexiones.RetrofitObject;
import com.example.pmdm_ejercicionavidad.modelos.Characters;
import com.example.pmdm_ejercicionavidad.modelos.DataItem;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PersonajeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<DataItem> personaje;
    private PersonajeAdapter adapter;
    private RecyclerView.LayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);

        recyclerView = findViewById(R.id.contenedorPersonaje);
        personaje = new ArrayList<>();
        adapter = new PersonajeAdapter(personaje,R.layout.personaje_view_holder, this);
        lm = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(lm);


        if(getIntent().getExtras().getString("PERSONAJE_ID")!=null){
          doGetPersonaje(getIntent().getExtras().getString("PERSONAJE_ID"));

        }else{
            Toast.makeText(this, "NO HAY PERSONAJE", Toast.LENGTH_SHORT).show();
        }

    }

    private void doGetPersonaje(String personajeId) {
        Retrofit retrofit = RetrofitObject.getConexion();
        ApiConexiones api = retrofit.create(ApiConexiones.class);

        Call<DataItem> getPersonaje = api.getPersonaje(personajeId);

        getPersonaje.enqueue(new Callback<DataItem>() {
            @Override
            public void onResponse(Call<DataItem> call, Response<DataItem> response) {
                if(response.code() == HttpsURLConnection.HTTP_OK && response.body() != null){

                    personaje.add(response.body());
                    adapter.notifyItemRangeInserted(0,personaje.size());
                }else{
                    Toast.makeText(PersonajeActivity.this, "error", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<DataItem> call, Throwable t) {
                Toast.makeText(PersonajeActivity.this, "error", Toast.LENGTH_SHORT).show();
                Log.e("FAILURE", t.getLocalizedMessage()); //para que imprima el error de lo sucedido
            }
        });



    }
}