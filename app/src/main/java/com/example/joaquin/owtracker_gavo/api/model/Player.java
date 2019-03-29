package com.example.joaquin.owtracker_gavo.api.model;

import com.google.gson.annotations.SerializedName;

public class Player {
    private String icon;
    @SerializedName("name")
    private String username;
    private int level;
    private String levelicon;
    private String prestigeicon;
    private int rating;
    private String ratingicon;
    private String ratingname;
    private int gameswon;

    public Player(String icon, String username, int level, String levelicon, String prestigeicon, int rating, String ratingicon, String ratingname, int gameswon) {
        this.icon = icon;
        this.username = username;
        this.level = level;
        this.levelicon = levelicon;
        this.prestigeicon = prestigeicon;
        this.rating = rating;
        this.ratingicon = ratingicon;
        this.ratingname = ratingname;
        this.gameswon = gameswon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLevelicon() {
        return levelicon;
    }

    public void setLevelicon(String levelicon) {
        this.levelicon = levelicon;
    }

    public String getPrestigeicon() {
        return prestigeicon;
    }

    public void setPrestigeicon(String prestigeicon) {
        this.prestigeicon = prestigeicon;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingicon() {
        return ratingicon;
    }

    public void setRatingicon(String ratingicon) {
        this.ratingicon = ratingicon;
    }

    public String getRatingname() {
        return ratingname;
    }

    public void setRatingname(String ratingname) {
        this.ratingname = ratingname;
    }

    public int getGameswon() {
        return gameswon;
    }

    public void setGameswon(int gameswon) {
        this.gameswon = gameswon;
    }
}

    //PROFILE NAME - GAMES WON - PLATFORM - LEVEL - RATING

