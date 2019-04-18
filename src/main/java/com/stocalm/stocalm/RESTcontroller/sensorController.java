package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Models.Reading;
import com.stocalm.stocalm.Models.Sensor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/sensors")
public class sensorController {

    @GetMapping("/{sensorId}")
    public Sensor getSensorById(@PathVariable int sensorId) {
        Sensor s1 = new Sensor(1, 1.3453, 0.53432);
        s1.addReading(new Reading("2018-01-05", "10:10", 3.2));
        s1.addReading(new Reading("2018-01-05", "10:20", 3.0));
        s1.addReading(new Reading("2018-01-05", "10:30", 3.5));
        Sensor s2 = new Sensor(2, 12.3453, 10.53432);
        s2.addReading(new Reading("2019-05-01", "20:30", 1.2));
        s2.addReading(new Reading("2019-05-01", "20:40", 1.1));
        s2.addReading(new Reading("2019-05-01", "20:50", 1.7));

        switch (sensorId) {
            case 1:
                return s1;
            case 2:
                return s2;
            default:
                return null;
        }

    }
}
