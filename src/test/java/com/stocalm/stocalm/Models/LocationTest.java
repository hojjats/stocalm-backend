package com.stocalm.stocalm.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    private Location location1, location2;
    private ArrayList<String> amenities;

    @BeforeEach
    void setUp() {
        location1 = new Location("Test location");

        amenities = new ArrayList<>();
        location2 = new Location("Second test location", "aTestUrl", amenities, "The second test location");
    }

    @Test
    void getDescription() {
        location1.setDescription("Test 1");
        assertEquals("Test 1", location1.getDescription());
        assertEquals("The second test location", location2.getDescription());
        assertNotEquals("The second test location", location1.getDescription());
    }

    @Test
    void setDescription() {
        location1.setDescription("Test 2");
        location1.setDescription("Test description");

        assertEquals("Test description", location1.getDescription());
        assertNotEquals("Test 2", location1.getDescription());
    }

    @Test
    void getName() {
        assertNotEquals("Not test", location1.getName());
        assertEquals("Test location", location1.getName());
    }

    @Test
    void getImgUrl() {
        assertEquals(null, location1.getImgUrl());
        assertEquals("aTestUrl", location2.getImgUrl());
        assertNotEquals(null, location2.getImgUrl());
    }

    @Test
    void getAmenities() {
        amenities.add("Playground");
        assertEquals("Playground", location2.getAmenities().get(0));
        amenities.add("WiFi");
        assertEquals("Playground", location2.getAmenities().get(0));
        assertEquals("WiFi", location2.getAmenities().get(1));
    }

    @Test
    void setName() {
        location1.setName("Another name");
        assertEquals("Another name", location1.getName());
        location1.setName("Another new name");
        assertEquals("Another new name", location1.getName());
    }

    @Test
    void setImgUrl() {
        assertEquals(null, location1.getImgUrl());
        location1.setImgUrl("testUrl/test");
        assertEquals("testUrl/test", location1.getImgUrl());
    }

    @Test
    void setAmenities() {
        ArrayList<String> aNewList = new ArrayList<>();
        aNewList.add("Item1");
        aNewList.add("Item2");

        location2.setAmenities(aNewList);
        assertEquals("Item2", location2.getAmenities().get(1));

        location1.setAmenities(aNewList);
        assertEquals("Item1", location2.getAmenities().get(0));
    }
}