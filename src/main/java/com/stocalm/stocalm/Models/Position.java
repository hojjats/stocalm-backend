package com.stocalm.stocalm.Models;

public class Position {

    private double lng;
    private double lat;
    private Location location;

    public Position() {

    }

    public Position(double lng, double lat, Location location) {
        this.lng = lng;
        this.lat = lat;
        this.location = location;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public Location getLocation() {
        return location;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return new StringBuilder(location.toString())
                .append(" [lat: ")
                .append(lat)
                .append(", lng: ")
                .append(lng)
                .append("]")
                .toString();
    }
}
