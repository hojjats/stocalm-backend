package com.stocalm.stocalm.RESTcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/sensors")
public class sensorController {

    @GetMapping("/{sensorId}")
    public String getSensorById(@PathVariable String sensorId) {
        return "Test ID: " + sensorId;
    }
}
