package com.example.yummyapp.model;

import com.google.gson.annotations.SerializedName;

public class MovieModel {
    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    public MovieModel(String title, String image) {
        this.name = title;
        this.image = image;

    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
