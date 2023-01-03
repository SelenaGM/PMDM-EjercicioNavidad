package com.example.pmdm_ejercicionavidad.conexiones;

import com.example.pmdm_ejercicionavidad.modelos.Characters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConexiones {

    @GET("/characters")
    Call<Characters> getCaracteres();

}
