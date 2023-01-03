package com.example.pmdm_ejercicionavidad.conexiones;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject{

    private static final String BASE_URL = "https://api.disneyapi.dev";

    public static Retrofit getConexion(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
