package com.example.joaquin.owtracker_gavo.api.service;

import com.example.joaquin.owtracker_gavo.api.deserializer.Deserializer;
import com.example.joaquin.owtracker_gavo.api.model.Player;
import com.google.gson.GsonBuilder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class API {

    public static final String BASE_URL = "https://ow-api.com/v1/stats/";
    public static Retrofit retrofit = null;

    public static Retrofit getAPI(){
        if (retrofit == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Player.class, new Deserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }

}