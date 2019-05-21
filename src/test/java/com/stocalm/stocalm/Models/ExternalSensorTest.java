package com.stocalm.stocalm.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalSensorTest {
    ExternalSensor externalSensor = new ExternalSensor();
    String testReadingApi = "test reading api";
    Position testPosition = new Position(11.0, 5.0, new Location("LocationName"));
    String testType = "A type";

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