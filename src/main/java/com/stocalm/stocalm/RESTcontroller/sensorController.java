package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Models.Reading;
import com.stocalm.stocalm.Models.Sensor;
import com.stocalm.stocalm.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/sensors")
public class sensorController {

    @Autowired
    private SensorService sensorService;

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

    @PostMapping("/post")
    public Sensor addSensor(@RequestBody Sensor sensor){
        return sensorService.addSensor(sensor);
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
    Graph
     */

    @GetMapping("/graph/weekdays/{sensorId}")
    public double[] getGraphValuesByWeekday(@PathVariable String sensorId) {
        return sensorService.getMeanValuesByWeekday(sensorId);
    }

    /*
    Test
     */

    @GetMapping("/test/{test}")
    public String test(@PathVariable String test) {
        return "Testar med: " + test;
    }
}
