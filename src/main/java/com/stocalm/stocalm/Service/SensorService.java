package com.stocalm.stocalm.Service;

import com.stocalm.stocalm.Models.*;
import com.stocalm.stocalm.Repository.ExternalSensorRepository;
import com.stocalm.stocalm.Repository.SensorRepository;
import com.stocalm.stocalm.constants.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private ExternalSensorRepository externalSensorRepository;
    @Autowired
    private ApiService apiService;

    public List<Sensor> getAllSensors() {
        List allSensors = getExternSensor();
        allSensors.addAll(sensorRepository.findAll());
        return allSensors;
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

    public Sensor addSensor(Sensor sensor){
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

    public List<Sensor> getExternSensor() {
        List<Sensor> externalSensors = new ArrayList<>();
        List<ExternalSensor> list = this.externalSensorRepository.findAll();
        list.forEach(externSensor -> {
            Sensor sensor;
            System.out.println(externSensor);
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

    private Sensor munisenseToSensor(ExternalSensor externalSensor) {
        Location location = new Location(externalSensor.getName());
        Position position = new Position(externalSensor.getLng(), externalSensor.getLat(), location);
        List<Reading> readings = new ArrayList<>();
        String json = apiService.getRequest(externalSensor.getApi());
        JSONObject jsonObj = new JSONObject(json);
        JSONArray jArr = jsonObj.getJSONArray("results");

        for (int n = 0; n < jArr.length(); n++) {
            JSONObject jsonReading = jArr.getJSONObject(n);
            String[] dateAndTime = timestampToDateAndTime(jsonReading.getString("timestamp"));
            Reading reading = new Reading(dateAndTime[0], dateAndTime[1], jsonReading.getDouble("avg"));
            readings.add(reading);
        }

        return new Sensor(position, readings);

    }

    private String[] timestampToDateAndTime(String timestamp) {
        String date = timestamp.substring(0, 10);
        String time = timestamp.substring(11, 19);
        String[] dateAndTime = {date, time};
        return dateAndTime;
    }

    public double[] getMeanValuesByWeekday(String sensorId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN);
        Sensor sensor = sensorRepository.getSensorById(sensorId);
        if (sensor != null) {
            List<Reading> readings = sensor.getReadings();

            if (readings != null) {
                ArrayList<ArrayList<Double>> values = new ArrayList<>();
                for (int i = 0; i < 7; i++) {
                    values.add(new ArrayList<>());
                }

                readings.forEach(reading -> {
                    if (reading.getDate().matches(Constants.DATE_REGEX)) {
                        LocalDate date = LocalDate.parse(reading.getDate(), formatter);
                        int day = date.getDayOfWeek().getValue() - 1; // Monday == 0, Sunday == 6
                        List<Double> dayValues = values.get(day);
                        dayValues.add(reading.getValue());
                    }
                });

                double[] meanValues = new double[7];

                for (int i = 0; i < values.size(); i++) {
                    List<Double> dayValues = values.get(i);
                    int count = 0;
                    double total = 0;
                    for (double value : dayValues) {
                        total += value;
                        count++;
                    }
                    if (count > 0) {
                        meanValues[i] = total / count;
                    }
                }
                return meanValues;
            }
        }
        return null;
    }

}
