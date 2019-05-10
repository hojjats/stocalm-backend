package com.stocalm.stocalm.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sensor {
    @Id
    private String id;
    private Position position;
    private List<Reading> readings;
    private List<List<Double>> hourMeanValue;
    private List<Double> weekdayMeanValue;

    public Sensor() {
        readings = new ArrayList<>();

        hourMeanValue = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            hourMeanValue.add(new ArrayList<>(24));
            for (int j = 0; j < 24; j++) {
                hourMeanValue.get(i).add(0.0);
            }
        }

        weekdayMeanValue = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            weekdayMeanValue.add(0.0);
        }
    }

    public Sensor(Position position, List<Reading> readings, List<List<Double>> hourMeanValue, List<Double> weekdayMeadValue) {
        this.position = position;
        this.readings = readings;
        this.hourMeanValue = hourMeanValue;
        this.weekdayMeanValue = weekdayMeadValue;
    }

    private void initiateMeanValuesArrays() {
        hourMeanValue = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            hourMeanValue.add(new ArrayList<>(24));
            for (int j = 0; j < 24; j++) {
                hourMeanValue.get(i).add(0.0);
            }
        }

        weekdayMeanValue = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            weekdayMeanValue.add(0.0);
        }
    }

    public String getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public List<Double> getWeekdayMeanValue() {
        return weekdayMeanValue;
    }

    public List<List<Double>> getHourMeanValue() {
        return hourMeanValue;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    public void setHourMeanValue(List<List<Double>> hourMeanValue) {
        this.hourMeanValue = hourMeanValue;
    }

    public void setWeekdayMeanValue(List<Double> weekdayMeanValue) {
        this.weekdayMeanValue = weekdayMeanValue;
    }

    public void addReading(Reading reading) {
        readings.add(reading);
    }


    public void setMeanValues() {
        if(hourMeanValue == null || weekdayMeanValue == null){
            initiateMeanValuesArrays();
        }

        //Sort readings
        List<List<List<Reading>>> sortedReadings;
        sortedReadings = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            sortedReadings.add(new ArrayList<>(24));
            for (int j = 0; j < 24; j++) {
                sortedReadings.get(i).add(new ArrayList<>());
            }
        }

        this.readings.forEach(reading -> {
            LocalDate date = LocalDate.parse(reading.getDate());
            LocalTime time = LocalTime.parse(reading.getTime());
            sortedReadings
                    .get(date.getDayOfWeek().getValue() - 1) // Monday == 0, Sunday == 6
                    .get(time.getHour())                     // 0 - 23
                    .add(reading);
        });

        for (int i = 0; i < sortedReadings.size(); i++) {

            int readingsPerDay = 0;
            double totalDayValue = 0;

            for (int j = 0; j < sortedReadings.get(i).size(); j++) {
                int readingsPerHour = 0;
                double totalHourValue = 0;

                for (Reading reading : sortedReadings.get(i).get(j)) {
                    // Add to day
                    readingsPerDay++;
                    totalDayValue += reading.getValue();
                    // Add to hour
                    readingsPerHour++;
                    totalHourValue += reading.getValue();
                }

                hourMeanValue.get(i).set(j, (readingsPerHour == 0 ? 0 : totalHourValue / readingsPerHour));
            }

            weekdayMeanValue.set(i, (readingsPerDay == 0 ? 0 : totalDayValue / readingsPerDay));
        }

    }

    @Override
    public String toString() {
        return new StringBuilder("Position: ")
                .append(position)
                .append(", Readings: ")
                .append(readings)
                .append("Medelvärde per veckodag: ")
                .append(weekdayMeanValue)
                .append("Medelvärde per timme: ")
                .append(hourMeanValue)
                .toString();
    }
}
