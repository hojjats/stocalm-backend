package com.stocalm.stocalm.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    Position emptyPostion = new Position();
    Location testLocation = new Location("Testlocation for position");
    Position testPosition = new Position(11.0, 5.5, testLocation);

    @Test
    void getLat() {
        assertEquals(5.5, testPosition.getLat());
    }

    @Test
    void getLng() {
        assertEquals(11.0, testPosition.getLng());
    }

    @Test
    void getLocation() {
        assertEquals(testLocation, testPosition.getLocation());
    }

    @Test
    void setLng() {
        assertEquals(11.0, testPosition.getLng());
        testPosition.setLng(4.0);
        assertEquals(4.0, testPosition.getLng());
        emptyPostion.setLng(4.5);
        assertEquals(4.5, emptyPostion.getLng());
    }

    @Test
    void setLat() {
        assertEquals(5.5, testPosition.getLat());
        testPosition.setLat(4.0);
        assertEquals(4.0, testPosition.getLat());
        emptyPostion.setLat(6.5);
        assertEquals(6.5, emptyPostion.getLat());
    }

    @Test
    void setLocation() {
        Location newLocation = new Location("This is new!");
        assertEquals(testLocation, testPosition.getLocation());
        testPosition.setLocation(newLocation);
        assertEquals(newLocation, testPosition.getLocation());
    }
}