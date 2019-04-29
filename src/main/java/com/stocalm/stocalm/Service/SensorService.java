package com.stocalm.stocalm.Service;

import com.stocalm.stocalm.Models.Reading;
import com.stocalm.stocalm.Models.Sensor;
import com.stocalm.stocalm.Repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    SensorRepository sensorRepository;

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public List<Reading> getReadingsBySensorId(String sensorId) {
        Sensor sensor = this.sensorRepository.getSensorById(sensorId);
        if (sensor != null) {
            List<Reading> readings = sensor.getReadings();
            if (readings == null) {
                readings = new ArrayList<>();
            }
            return readings;
        } else {
            // TODO -> Exception
            return null;
        }
    }

    public Reading addReading(String sensorId, Reading reading) {
        Sensor sensor = this.sensorRepository.getSensorById(sensorId);
        sensor.addReading(reading);
        Sensor updatedSensor = this.sensorRepository.save(sensor);
        if (updatedSensor != null) {
            return reading;
        } else {
            // TODO -> Exception
            return null;
        }
    }

}
