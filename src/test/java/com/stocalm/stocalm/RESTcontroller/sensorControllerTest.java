package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Models.Location;
import com.stocalm.stocalm.Models.Position;
import com.stocalm.stocalm.Models.Reading;
import com.stocalm.stocalm.Models.Sensor;
import com.stocalm.stocalm.Service.SensorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class sensorControllerTest {

    @InjectMocks
    sensorController sensorController;

    @Mock
    SensorService sensorService;

    private String sensorID;
    private Sensor sensor, emptySensor;
    private Reading reading;
    private Position position;
    private List<Reading> readingList;
    private List<List<Double>> hourMeanValueList;
    private List<Double> weekdayMeanValueList;

    @BeforeEach
    void setUp() {
        sensorID = "s500";
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
    void getSensors() {
        List<Sensor> sensorList = new ArrayList<>();
        sensorList.add(sensor);
        when(sensorService.getAllSensors()).thenReturn(sensorList);
        List<Sensor> returnedSensorList = sensorController.getSensors();
        verify(sensorService).getAllSensors();
    }

    @Test
    void getSensorById() {
        Sensor returnedSensor = sensorController.getSensorById(sensorID);
        assertEquals(null, returnedSensor);
    }

    @Test
    void addSensor() {
        when(sensorService.addSensor(sensor)).thenReturn(sensor);
        Sensor returnedSensor = sensorController.addSensor(sensor);
        assertEquals(returnedSensor, sensor);
    }

    @Test
    void getReadingsBySensorId() {
        when(sensorService.getReadingsBySensorId(sensorID)).thenReturn(readingList);
        List<Reading> returnedReadingList = sensorController.getReadingsBySensorId(sensorID);
        verify(sensorService).getReadingsBySensorId(sensorID);
        assertEquals(returnedReadingList, readingList);
    }

    @Test
    void addReading() {
        when(sensorService.addReading(sensorID, reading)).thenReturn(reading);
        Reading returnedReading = sensorController.addReading(sensorID, reading);
        verify(sensorService).addReading(sensorID, reading);
        assertEquals(returnedReading, reading);
    }

    @Test
    void addReadingWithGetMethod() {
        Reading readingToAdd = new Reading("2019-05-05", "13:37", 30);
        when(sensorService.addReading(sensorID, readingToAdd)).thenReturn(readingToAdd);
        Reading returnedReading = sensorController.addReadingWithGetMethod(sensorID, "30", "2019-05-05", "13:37");
        verify(sensorService).addReading(sensorID, readingToAdd);
        assertEquals(readingToAdd, returnedReading);
    }

}