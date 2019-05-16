package com.stocalm.stocalm.Models;

public class ExternalSensor {

    String readingsApi;
    Position position;
    String type;

    public ExternalSensor() {

    }

    public Position getPosition() {
        return position;
    }

    public String getReadingsApi() {
        return readingsApi;
    }

    public String getType() {
        return type;
    }

    public void setReadingsApi(String readingsApi) {
        this.readingsApi = readingsApi;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringBuilder("Type: ")
                .append(type)
                .append(", Api: ")
                .append(readingsApi)
                .append(", Position: ")
                .append(position)
                .append("]")
                .toString();
    }
}
