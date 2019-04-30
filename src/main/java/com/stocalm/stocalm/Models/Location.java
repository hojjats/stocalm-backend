package com.stocalm.stocalm.Models;

public class Location {
    private String name;
    private String imgUrl;

    public Location() {

    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return name;
    }
}
