package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Models.Reading;
import com.stocalm.stocalm.Models.Sensor;
import com.stocalm.stocalm.Service.SensorService;
import com.stocalm.stocalm.Repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/sensors")
public class sensorController {

    @Autowired
    private SensorService sensorService;
    @Autowired
    private SensorRepository sensorRepository;

    /*
    Sensors
     */

    @GetMapping("")
    public List<Sensor> getSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/{sensorId}")
    public Sensor getSensorById(@PathVariable String sensorId) {
        return null;
    }

    /*
    Readings
     */

    @GetMapping("/readings/{sensorId}")
    public List<Reading> getReadingsBySensorId(@PathVariable String sensorId) {
        return this.sensorService.getReadingsBySensorId(sensorId);
    }

    @PostMapping("/readings/{sensorId}")
    public Reading addReading(@PathVariable String sensorId, @RequestBody Reading reading) {
        return this.sensorService.addReading(sensorId, reading);
    }

    /*
    Test
     */

    @GetMapping("/test/{test}")
    public String test(@PathVariable String test) {
        return "Testar med: " + test;
    }
    
    @GetMapping("/test")
    public Reading testForSensorWithGet() {
        LocalDateTime date = LocalDateTime.now();
        Reading r = new Reading(date.toLocalDate().toString(), date.toLocalTime().toString(), 20);
        Sensor s = this.sensorRepository.findAll().get(0);
        s.getReadings().add(r);
        this.sensorRepository.save(s);
        return r;
    }

    @PostMapping("/test")
    public Reading testForSensorWithPost() {
        LocalDateTime date = LocalDateTime.now();
        Reading r = new Reading(date.toLocalDate().toString(), date.toLocalTime().toString(), 30);
        Sensor s = this.sensorRepository.findAll().get(0);
        s.getReadings().add(r);
        this.sensorRepository.save(s);
        return r;
    }
    
    @GetMapping("/id/{id}/value/{value}/date/{date}/time/{time}")
    public Reading addSensorTest(@PathVariable String id, @PathVariable String value, @PathVariable String date, @PathVariable String time) {
        double doubleValue = Double.parseDouble(value);
        Reading reading = new Reading(date, time, doubleValue);
        Sensor sensor = this.sensorRepository.getSensorById(id);
        sensor.getReadings().add(reading);
        this.sensorRepository.save(sensor);
        return reading;
    }
    
}
