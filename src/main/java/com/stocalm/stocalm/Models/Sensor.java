package com.stocalm.stocalm.Models;

import java.util.ArrayList;

public class Sensor {
    private int id;
    private double x;
    private double y;
    private ArrayList<Reading> readings;

    public Sensor(int id, double x, double y) {
        this(id, x, y, new ArrayList<>());
    }

    public Sensor(int id, double x, double y, ArrayList<Reading> readings) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.readings = readings;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public ArrayList<Reading> getReadings() {
        return readings;
    }

    public void addReading(Reading reading) {
        readings.add(reading);
    }
}
