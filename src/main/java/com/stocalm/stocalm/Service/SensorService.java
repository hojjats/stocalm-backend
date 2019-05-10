package com.stocalm.stocalm.Service;

import com.stocalm.stocalm.Models.*;
import com.stocalm.stocalm.Repository.ExternalSensorRepository;
import com.stocalm.stocalm.Repository.SensorRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private ExternalSensorRepository externalSensorRepository;
    @Autowired
    private ApiService apiService;


   /*
    // Executes when initiating class
    @PostConstruct
    private void init() {
    }
    */

    // Update mean values every 12 hours
    @Scheduled(fixedDelay = 43200000)
    private void updateSensorsFormDB() {
        List<Sensor> sensorsFromDB = this.sensorRepository.findAll();
        updateMeanValues(sensorsFromDB);
        sensorsFromDB.forEach(sensor -> this.sensorRepository.save(sensor));
        System.out.println("Mean values updated!");
    }

    private void updateMeanValues(List<Sensor> sensors) {
        sensors.forEach(sensor -> sensor.setMeanValues());
    }

    public List<Sensor> getAllSensors() {
        List sensors = getExternalSensor();
        this.updateMeanValues(sensors);     // Calculate external sensors mean values
        sensors.addAll(sensorRepository.findAll());
        return sensors;
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

    public Sensor addSensor(Sensor sensor) {
        sensorRepository.save(sensor);
        return sensor;
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

    public List<Sensor> getExternalSensor() {
        List<Sensor> externalSensors = new ArrayList<>();
        List<ExternalSensor> list = this.externalSensorRepository.findAll();
        list.forEach(externSensor -> {
            Sensor sensor;
            switch (externSensor.getType()) {
                case "munisense":
                    sensor = munisenseToSensor(externSensor);
                    break;
                default:
                    sensor = null;
            }
            if (sensor != null) {
                externalSensors.add(sensor);
            }
        });
        return externalSensors;
    }

    /**
     * Converts a ExternalSensor object with type munisense to a Sensor object
     * <p>
     * The JSON response from the API should have the structure:
     * {
     * "results": [
     * {"timestamp":"2019-04-04T14:44:35.000+00:00",
     * "avg":44.6877,
     * "min":34.69,
     * "max":68.56}
     * ],
     * "meta":{}
     * }
     *
     * @param externalSensor
     * @return Sensor object
     */
    private Sensor munisenseToSensor(ExternalSensor externalSensor) {
        // Create new objects
        Location location = new Location(externalSensor.getName());
        Position position = new Position(externalSensor.getLng(), externalSensor.getLat(), location);
        List<Reading> readings = new ArrayList<>();
        // Get values from API and convert it to JSONObject
        String json = apiService.getRequest(externalSensor.getApi());
        JSONObject jsonObj = new JSONObject(json);
        // Get the array of readings and loop through it
        JSONArray jArr = jsonObj.getJSONArray("results");
        for (int n = 0; n < jArr.length(); n++) {
            // Get values from reading and create a new reading object
            JSONObject jsonReading = jArr.getJSONObject(n);
            String timeStamp = jsonReading.getString("timestamp");
            ZonedDateTime dateTime = ZonedDateTime.parse(timeStamp);
            String date = dateTime.toLocalDate().toString();
            String time = dateTime.toLocalTime().toString();
            Reading reading = new Reading(date, time, jsonReading.getDouble("avg"));
            readings.add(reading);
        }
        // Create a new sensor object and return it
        return new Sensor(position, readings, null, null);

    }

}
