package com.stocalm.stocalm.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadingTest {

    String testDate = "2019-05-05";
    String testTime = "12:00";
    double testValue = 42.0;
    Reading reading = new Reading(testDate, testTime, testValue);

    @Test
    void getValue() {
        assertEquals(42.0, reading.getValue());
    }

    @Test
    void getDate() {
        assertEquals("2019-05-05", reading.getDate());
    }

    @Test
    void getTime() {
        assertEquals("12:00", reading.getTime());
    }

    @Test
    void setDate() {
        assertEquals("2019-05-05", reading.getDate());
        reading.setDate("2019-06-06");
        assertEquals("2019-06-06", reading.getDate());

    }

    @Test
    void setTime() {
        assertEquals("12:00", reading.getTime());
        reading.setTime("13:00");
        assertEquals("13:00", reading.getTime());
    }

    @Test
    void setValue() {
        assertEquals(42.0, reading.getValue());
        reading.setValue(2);
        assertEquals(2.0, reading.getValue());
    }
}