package com.stocalm.stocalm.Models;

import java.util.ArrayList;

public class Location {
    private String name;
    private String imgUrl;
    private ArrayList<String> amenities;
    private String description;

    public Location() {
        this(null);
    }

    public Location(String name) {
        this(name, null, new ArrayList<>(),null);
    }

    public Location(String name, String imgUrl, ArrayList<String> amenities, String description) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.amenities = amenities;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return name;
    }
}
