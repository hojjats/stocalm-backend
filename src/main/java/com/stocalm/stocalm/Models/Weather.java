package com.stocalm.stocalm.Models;

public class Weather {
    String iconUrl;
    double temp;
    String date;
    String time;

    public Weather() {

    }

    public Weather(double temp, String imgUrl) {
        this(temp, imgUrl, null, null);
    }

    public Weather(double temp, String imgUrl, String date, String time) {
        this.iconUrl = imgUrl;
        this.temp = temp;
        this.date = date;
        this.time = time;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public double getTemp() {
        return temp;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
