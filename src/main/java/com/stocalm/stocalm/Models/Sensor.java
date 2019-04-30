package com.stocalm.stocalm.Models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    @Id
    private String id;
    private Position position;
    private List<Reading> readings;

    public Sensor() {
        readings = new ArrayList<>();
    }

    public Sensor(Position position, List<Reading> readings) {
        this.readings = readings;
    }

    public String getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    public void setReadings(ArrayList<Reading> readings) {
        this.readings = readings;
    }

    public void addReading(Reading reading) {
        readings.add(reading);
    }
}
