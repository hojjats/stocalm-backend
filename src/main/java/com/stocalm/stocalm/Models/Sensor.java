package com.stocalm.stocalm.Models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Sensor {
    @Id
    private String id;
    private String name;
    private double lng;
    private double lat;
    private ArrayList<Reading> readings;

    public Sensor() {
        readings = new ArrayList<>();
    }

    public Sensor(String name, double lng, double lat, ArrayList<Reading> readings) {
        this.name = name;
        this.lng = lng;
        this.lat = lat;
        this.readings = readings;
    }

    public String getId() {
        return id;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Reading> getReadings() {
        return readings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setReadings(ArrayList<Reading> readings) {
        this.readings = readings;
    }

    public void addReading(Reading reading) {
        readings.add(reading);
    }
}
