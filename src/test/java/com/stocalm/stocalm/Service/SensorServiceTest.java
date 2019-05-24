package com.stocalm.stocalm.Service;

import com.stocalm.stocalm.Models.Location;
import com.stocalm.stocalm.Models.Position;
import com.stocalm.stocalm.Models.Reading;
import com.stocalm.stocalm.Models.Sensor;
import com.stocalm.stocalm.Repository.SensorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SensorServiceTest {

    @Mock
    private SensorRepository sensorRepository;

    @InjectMocks
    private SensorService sensorService;

    private Sensor sensor, emptySensor;
    private String sensorID;
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
                        new Reading("2019-05-01", "12:00", 10.0),
                        new Reading("2019-05-02", "13:00", 10),
                        new Reading("2019-05-03", "14:00", 13)));

        hourMeanValueList = new ArrayList<List<Double>>(
                Arrays.asList(new ArrayList<Double>(
                                Arrays.asList(10.0, 11.0)
                        ), new ArrayList<Double>(
                                Arrays.asList(20.0, 21.0)
                        )
                ));
        weekdayMeanValueList = new ArrayList<Double>(
                Arrays.asList(15.0, 16.0)
        );

        sensor = new Sensor(position, readingList, hourMeanValueList, weekdayMeanValueList);
        emptySensor = new Sensor();
        sensorID = "s500";
    }


    @Test
    @DisplayName("Get list of readings by sensor ID")
    void getReadingsBySensorId() {
        when(sensorRepository.getSensorById(sensorID)).thenReturn(sensor);

        List<Reading> returnedReadings = sensorService.getReadingsBySensorId("s500");
        verify(sensorRepository).getSensorById("s500");
        verify(sensorRepository, never()).getSensorById("300");
        verify(sensorRepository, never()).getSensorById(null);

        assertEquals(readingList, returnedReadings);
    }

    @Test
    @DisplayName("Get list of readings by sensor ID null: expected null")
    void getReadingsBySensorIdNull() {
        List<Reading> returnedReadings = sensorService.getReadingsBySensorId(null);
        verify(sensorRepository).getSensorById(null);

        assertEquals(returnedReadings, null);
    }

    @Test
    void addSensor() {
        sensorService.addSensor(sensor);

        verify(sensorRepository).save(sensor);
        verify(sensorRepository, never()).save(emptySensor);
    }

    /*
    @Test
    void addReading() {
    }

        @Test
    void getAllSensors() {
    }

    @Test
    void getExternalSensor() {
    }
    */
}