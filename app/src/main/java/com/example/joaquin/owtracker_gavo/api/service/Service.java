package com.example.joaquin.owtracker_gavo.api.service;

import com.example.joaquin.owtracker_gavo.api.model.Player;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("pc/us/{player}/profile")
    Call<Player> getPlayer(@Path("player") String username);
}
