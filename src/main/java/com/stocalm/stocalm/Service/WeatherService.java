package com.stocalm.stocalm.Service;

import com.stocalm.stocalm.Models.Weather;
import com.stocalm.stocalm.constants.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WeatherService {

    @Autowired
    private ApiService apiService;

    String baseURL = "https://api.openweathermap.org/data/2.5";
    String realTimeURI = "/weather";
    String forecastURI = "/forecast";
    String iconBaseUrl = "https://openweathermap.org/img/w/";

    public Weather getRealTimeWeatherByPoint(String lng, String lat) {
        // Construct URL
        StringBuilder url = new StringBuilder(baseURL);
        url.append(realTimeURI);
        // Construct parameters
        Map<String, String> params = new HashMap<>();
        params.put("lat", lat);
        params.put("lon", lng);
        params.put("APPID", Constants.OPENWEATHERMAP_KEY);
        // Do API call
        String jsonResponse = apiService.getRequestWithParams(url.toString(), params);
        JSONObject jsonObj = new JSONObject(jsonResponse);
        // Get temp (in Kelvin) and convert to Celsius
        double temp = jsonObj.getJSONObject("main").getDouble("temp");
        temp = kelvinToCelsius(temp);
        // Get weather symbol
        String icon = jsonObj.getJSONArray("weather").getJSONObject(0).getString("icon");
        String iconUrl = new StringBuilder(iconBaseUrl).append(icon).append(".png").toString();
        // Return new Weather object
        return new Weather(temp, iconUrl);

    }

    public List<Weather> getForecastByPoint(String lng, String lat) {
        List<Weather> weatherList = new ArrayList<>();
        // Construct URL
        StringBuilder url = new StringBuilder(baseURL);
        url.append(forecastURI);
        // Construct parameters
        Map<String, String> params = new HashMap<>();
        params.put("lat", lat);
        params.put("lon", lng);
        params.put("APPID", Constants.OPENWEATHERMAP_KEY);
        // Do API call
        String jsonResponse = apiService.getRequestWithParams(url.toString(), params);
        JSONObject jsonObj = new JSONObject(jsonResponse);
        // Loop through weather list and create new Weather objects
        JSONArray jsonArr = jsonObj.getJSONArray("list");
        for (int i = 0; i < jsonArr.length(); i++) {
            JSONObject o = jsonArr.getJSONObject(i);
            double temp = o.getJSONObject("main").getDouble("temp");
            temp = kelvinToCelsius(temp);
            String icon = o.getJSONArray("weather").getJSONObject(0).getString("icon");
            String iconUrl = new StringBuilder(iconBaseUrl).append(icon).append(".png").toString();
            String date = o.getString("dt_txt").substring(0, 10);
            String time = o.getString("dt_txt").substring(11);
            weatherList.add(new Weather(temp, iconUrl, date, time));
        }

        return weatherList;
    }

    private double kelvinToCelsius(double kelvinValue) {
        return kelvinValue - 273.15;
    }

}
