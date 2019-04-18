package com.stocalm.stocalm.Models;

public class Reading {
    private String date;
    private String time;
    private double value;

    public Reading(String date, String time, double value) {
        this.date = date;
        this.time = time;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return new StringBuilder(date)
                .append(", ")
                .append(time)
                .append(", ")
                .append(value)
                .toString();
    }
}
