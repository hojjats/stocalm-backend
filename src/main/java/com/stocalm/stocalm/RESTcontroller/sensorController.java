package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Models.Reading;
import com.stocalm.stocalm.Models.Sensor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/sensors")
public class sensorController {

    //Only for testing
    ArrayList<Sensor> sensors = new ArrayList<>();
    public sensorController() {
        Sensor s1 = new Sensor(1, "Rålambshovsparken", 18.024202, 59.328784);
        s1.addReading(new Reading("2018-02-22", "10:00", 5.5));
        s1.addReading(new Reading("2018-02-22", "12:00", 3.5));
        sensors.add(s1);
        Sensor s2 = new Sensor(2, "Tanto", 18.035978, 59.313884);
        s2.addReading(new Reading("2018-02-22", "10:00", 1.5));
        s2.addReading(new Reading("2018-02-22", "12:00", 2.5));
        sensors.add(s2);
    }

    @GetMapping("")
    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    @GetMapping("/{sensorId}")
    public Sensor getSensorById(@PathVariable String sensorId) {

        //Only for testing
        switch (sensorId) {
            case "1":
                return sensors.get(0);
            case "2":
                return sensors.get(1);
            default:
                return null;
        }

    }

    @GetMapping("/test/{test}")
    public String test(@PathVariable String test) {
        return "Testar med: " + test;
    }
}
