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
        assertNotEquals(0, sensor.getId());
    }

    @Test
    void getPosition() {
        assertEquals(position, sensor.getPosition());
        assertNotEquals(null, sensor.getPosition());
    }

    @Test
    void getReadings() {
        assertNotEquals(null, sensor.getReadings());
    }

    @Test
    void getWeekdayMeanValue() {
        assertNotEquals(-1, sensor.getWeekdayMeanValue());
        assertNotEquals(null, sensor.getWeekdayMeanValue());
    }

    @Test
    void getHourMeanValue() {
        assertNotEquals(-1, sensor.getHourMeanValue());
        assertNotEquals(null, sensor.getWeekdayMeanValue());
    }

    @Test
    void setId() {
        assertEquals(null, emptySensor.getId());
        assertNotEquals("1001", emptySensor.getId());
        emptySensor.setId("1001");
        assertEquals("1001", emptySensor.getId());
        sensor.setId("2000");
        assertEquals("2000", sensor.getId());
    }



    @Test
    void setPosition() {
        assertEquals(position, sensor.getPosition());
        Position newPos = new Position(11.0, 40.0, new Location("Another location!"));
        sensor.setPosition(newPos);
        assertEquals(newPos, sensor.getPosition());

    }


    @Test
    void setReadings() {
        assertEquals(readingList, sensor.getReadings());

        List<Reading> newReadingList = new ArrayList<Reading>(
                Arrays.asList(
                        new Reading("2019-05-05", "20:00", 60.0),
                        new Reading("2019-05-06", "21:00", 70),
                        new Reading("2019-05-07", "22:00", 80)));

        sensor.setReadings(newReadingList);
        assertNotEquals(readingList, sensor.getReadings());
        assertNotEquals(null, sensor.getReadings());
        assertEquals(newReadingList, sensor.getReadings());
    }


    @Test
    void setHourMeanValue() {

        assertEquals(hourMeanValueList, sensor.getHourMeanValue());

        List<List<Double>> newHourMeanValueList = new ArrayList<List<Double>>(
                Arrays.asList(new ArrayList<Double>(
                                Arrays.asList(20.0, 30.0)
                        ), new ArrayList<Double>(
                                Arrays.asList(45.0, 55.0)
                        )
                ));
        sensor.setHourMeanValue(newHourMeanValueList);
        assertNotEquals(null, sensor.getHourMeanValue());
        assertEquals(newHourMeanValueList, sensor.getHourMeanValue());
    }



    @Test
    void setWeekdayMeanValue() {
        assertEquals(weekdayMeanValueList, sensor.getWeekdayMeanValue());

        List<Double> newWeekdayMeanValueList = new ArrayList<Double>(
                Arrays.asList(20.0, 30.0, 40.0, 20.0, 20.0, 30.0, 30.0)
        );

        sensor.setWeekdayMeanValue(newWeekdayMeanValueList);
        assertNotEquals(null, sensor.getWeekdayMeanValue());
        assertEquals(newWeekdayMeanValueList, sensor.getWeekdayMeanValue());

    }

    @Test
    void addReading() {
        Reading newReading = new Reading("2001-10-10", "13:37", 43);
        int readingSize = sensor.getReadings().size();
        sensor.addReading(newReading);
        assertTrue(readingSize +1 == sensor.getReadings().size());
        assertNotEquals(null, sensor.getReadings());

        sensor.addReading(new Reading("2002-02-02", "12:22", 33));
        assertTrue(readingSize +2 == sensor.getReadings().size());
    }

}