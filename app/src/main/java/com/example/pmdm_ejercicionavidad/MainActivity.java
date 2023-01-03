package com.example.pmdm_ejercicionavidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pmdm_ejercicionavidad.adapters.CaracteresAdapters;
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

public class MainActivity extends AppCompatActivity {

    private RecyclerView contenedor;
    private List<DataItem> caracteresList;
    private CaracteresAdapters adapter;
    private RecyclerView.LayoutManager lm;

    

    private Retrofit retrofit;
    private ApiConexiones api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenedor = findViewById(R.id.contenedor);
        caracteresList = new ArrayList<>();
        adapter = new CaracteresAdapters(caracteresList, R.layout.caracteres_view_holder, this);
        lm = new LinearLayoutManager(this);

        contenedor.setAdapter(adapter);
        contenedor.setLayoutManager(lm);

        retrofit= RetrofitObject.getConexion();
        api = retrofit.create(ApiConexiones.class);

        cargarCaracteres();


    }

    private void cargarCaracteres() {
        Call<Characters> doGetCaracteres = api.getCaracteres();

        doGetCaracteres.enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                if(response.code() == HttpsURLConnection.HTTP_OK && response.body()!=null){
                    caracteresList.addAll(response.body().getData());
                    adapter.notifyItemRangeInserted(0,caracteresList.size());
                    }else{
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                Log.e("FAILURE", t.getLocalizedMessage()); //para que imprima el error de lo sucedido

            }
        });

    }
}