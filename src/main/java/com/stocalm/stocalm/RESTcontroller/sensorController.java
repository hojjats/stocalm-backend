package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Models.Reading;
import com.stocalm.stocalm.Models.Sensor;
import com.stocalm.stocalm.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/sensors")
public class sensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("")
    public List<Sensor> getSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/{sensorId}")
    public Sensor getSensorById(@PathVariable String sensorId) {
        return null;
    }

    @GetMapping("/test/{test}")
    public String test(@PathVariable String test) {
        return "Testar med: " + test;
    }
}
