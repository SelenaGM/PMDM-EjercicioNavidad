package com.example.pmdm_ejercicionavidad.conexiones;

import com.example.pmdm_ejercicionavidad.modelos.Characters;
import com.example.pmdm_ejercicionavidad.modelos.DataItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiConexiones {

    @GET("/characters?")
    Call<Characters> getCaracteres(@Query("page") String pagina);

    @GET("/characters/{id}/")
    Call<DataItem> getPersonaje(@Path("id")String id);

}
