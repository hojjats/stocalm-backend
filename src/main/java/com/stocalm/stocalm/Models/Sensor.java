package com.stocalm.stocalm.Models;

import java.util.ArrayList;

public class Sensor {
    private int id;
    private String name;
    private double lng;
    private double lat;
    private ArrayList<Reading> readings;

    public Sensor(int id, String name, double lng, double lat) {
        this(id, name, lng, lat, new ArrayList<>());
    }

    public Sensor(int id, String name, double lng, double lat, ArrayList<Reading> readings) {
        this.id = id;
        this.name = name;
        this.lng = lng;
        this.lat = lat;
        this.readings = readings;
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

    public void addReading(Reading reading) {
        readings.add(reading);
    }
}
