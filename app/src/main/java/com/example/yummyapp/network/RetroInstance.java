package com.example.yummyapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String BASE_URL = "https://navneet7k.github.io/"; //weebyapi lol - https://jsonplaceholder.typicode.com/

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
