package com.stocalm.stocalm.Service;

import com.stocalm.stocalm.Models.Sensor;
import com.stocalm.stocalm.Repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    @Autowired
    SensorRepository sensorRepository;

    public Sensor addSensor(Sensor sensor){
        sensorRepository.save(sensor);
        return sensor;
    }

    public List<Sensor> getAllSensors(){
       return sensorRepository.findAll();
    }
}
