package com.stocalm.stocalm.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalSensorTest {
    ExternalSensor externalSensor;
    String testReadingApi, testType;
    Position testPosition;

    @BeforeEach
    void setUp() {
        externalSensor = new ExternalSensor();
        testReadingApi = "test reading api";
        testPosition = new Position(11.0, 5.0, new Location("LocationName"));
        testType = "A type";
    }

    @Test
    void setReadingsApi() {
        assertEquals(null, externalSensor.getReadingsApi());
        externalSensor.setReadingsApi(testReadingApi);
        assertEquals("test reading api", externalSensor.getReadingsApi());
    }

    @Test
    void setPosition() {
        assertEquals(null, externalSensor.getPosition());
        externalSensor.setPosition(testPosition);
        assertEquals(testPosition, externalSensor.getPosition());
    }

    @Test
    void setType() {
        assertEquals(null, externalSensor.getType());
        externalSensor.setType(testType);
        assertEquals("A type", externalSensor.getType());
    }

}