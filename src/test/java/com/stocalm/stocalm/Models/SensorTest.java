package com.stocalm.stocalm.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {
    private Sensor emptySensor, sensor;
    private Position position;
    private List<Reading> readingList;
    private List<List<Double>> hourMeanValueList;
    private List<Double> weekdayMeanValueList;



    @BeforeEach
    void setUp() {
        position = new Position(5.0, 6.0, new Location("Test location"));
        // String date, String time, double value
        readingList = new ArrayList<Reading>(
                Arrays.asList(
                        new Reading("2019-05-05", "12:00", 40.0),
                        new Reading("2019-05-06", "13:00", 40),
                        new Reading("2019-05-07", "13:00", 43)));

        hourMeanValueList = new ArrayList<List<Double>>(
                Arrays.asList(new ArrayList<Double>(
                        Arrays.asList(40.0, 50.0)
                        ), new ArrayList<Double>(
                                Arrays.asList(50.0, 60.0)
                        )
                ));
        weekdayMeanValueList = new ArrayList<Double>(
                Arrays.asList(30.0, 40.0)
        );


        emptySensor = new Sensor();
        sensor = new Sensor(position, readingList, hourMeanValueList, weekdayMeanValueList);
    }

    @Test
    void getId() {
        assertNotEquals(null, sensor.getId());
        assertNotEquals(0, sensor.getId());
    }

    @Test
    void getPosition() {
    }

    @Test
    void getReadings() {
    }

    @Test
    void getWeekdayMeanValue() {
    }

    @Test
    void getHourMeanValue() {
    }

    @Test
    void setId() {
    }

    @Test
    void setPosition() {
    }

    @Test
    void setReadings() {
    }

    @Test
    void setHourMeanValue() {
    }

    @Test
    void setWeekdayMeanValue() {
    }

    @Test
    void addReading() {
    }

    @Test
    void setMeanValues() {
    }
}