package com.stocalm.stocalm.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {
    Weather emptyWeather, weather;
    double temp;
    String iconUrl, date, time;


    @BeforeEach
    void setUp() {
        temp = 23.0;
        iconUrl = "thisIsA/url/forIcon";
        date = "2019-05-20";
        time = "13:37";
        emptyWeather = new Weather();
        weather = new Weather(temp, iconUrl, date, time);

    }

    @Test
    void getIconUrl() {
        assertNotEquals(null, weather.getIconUrl());
        assertEquals(iconUrl, weather.getIconUrl());
    }

    @Test
    void getTemp() {
        assertNotEquals(null, weather.getTemp());
        assertEquals(temp, weather.getTemp());
    }

    @Test
    void getTime() {
        assertNotNull(weather.getTime());
        assertEquals(time, weather.getTime());
    }

    @Test
    void getDate() {
        assertNotEquals(null, weather.getDate());
        assertEquals(date, weather.getDate());
    }

    @Test
    void setIconUrl() {
        String newIconUrl = "this/isANew/url";
        weather.setIconUrl(newIconUrl);
        assertNotEquals(null, weather.getIconUrl());
        assertEquals(newIconUrl, weather.getIconUrl());
    }

    @Test
    void setTemp() {
        weather.setTemp(17.0);
        assertNotEquals(null, weather.getTemp());
        assertEquals(17.0, weather.getTemp());
    }

    @Test
    void setTime() {
        weather.setTime("15:33");
        assertNotEquals(null, weather.getTime());
        assertEquals("15:33", weather.getTime());
    }

    @Test
    void setDate() {
        weather.setDate("2019-01-23");
        assertNotEquals(null, weather.getDate());
        assertEquals("2019-01-23", weather.getDate());
    }
}