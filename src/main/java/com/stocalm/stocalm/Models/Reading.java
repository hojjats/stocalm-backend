package com.stocalm.stocalm.Models;

import java.util.Objects;

public class Reading {
    private String date;
    private String time;
    private double value;

    public Reading() {

    }

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

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setValue(double value) {
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reading)) return false;
        Reading reading = (Reading) o;
        return Double.compare(reading.getValue(), getValue()) == 0 &&
                Objects.equals(getDate(), reading.getDate()) &&
                Objects.equals(getTime(), reading.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTime(), getValue());
    }
}
