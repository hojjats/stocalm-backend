package com.stocalm.stocalm.Models;

public class ExternalSensor {

    String api;
    String name;
    double lat;
    double lng;
    String type;

    public ExternalSensor() {

    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

    public String getName() {
        return name;
    }

    public String getApi() {
        return api;
    }

    public String getType() {
        return type;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringBuilder("Type: ")
                .append(type)
                .append(", Api: ")
                .append(api)
                .append(", Name: ")
                .append(name)
                .append(", [Lat: ")
                .append(lat)
                .append(", Lng: ")
                .append(lng)
                .append("]")
                .toString();
    }
}
