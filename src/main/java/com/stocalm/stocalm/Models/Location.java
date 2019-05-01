package com.stocalm.stocalm.Models;

public class Location {
    private String name;
    private String imgUrl;

    public Location() {

    }

    public Location(String name) {
        this.name = name;
    }

    public Location(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
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
