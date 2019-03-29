package com.example.joaquin.owtracker_gavo.api.deserializer;

import com.example.joaquin.owtracker_gavo.api.model.Player;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Deserializer implements JsonDeserializer<Player> {


    @Override
    public Player deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        String icon = json.getAsJsonObject().get("icon").getAsString();
        String username = json.getAsJsonObject().get("name").getAsString();
        int level = json.getAsJsonObject().get("level").getAsInt();
        String levelicon = json.getAsJsonObject().get("levelIcon").getAsString();
        String prestigeicon = json.getAsJsonObject().get("prestigeIcon").getAsString();
        int rating = json.getAsJsonObject().get("rating").getAsInt();
        String ratingicon = json.getAsJsonObject().get("ratingIcon").getAsString();
        String ratingname = json.getAsJsonObject().get("ratingName").getAsString();
        int gameswon = json.getAsJsonObject().get("gamesWon").getAsInt();

        Player player = new Player(icon, username, level, levelicon, prestigeicon, rating, ratingicon, ratingname, gameswon);
        return player;
    }
}
