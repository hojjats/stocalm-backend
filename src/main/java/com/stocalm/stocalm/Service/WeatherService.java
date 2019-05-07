package com.stocalm.stocalm.Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Service
public class WeatherService {

    @Autowired
    private ApiService apiService;

    String base_url = "https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/";

    public String getTenDaysForecastByPoint(String lng, String lat) {

        StringBuilder api = new StringBuilder(base_url)
                .append("geotype/point/lon/")
                .append(lng)
                .append("/lat/")
                .append(lat)
                .append("/data.json");

        return apiService.getRequest(api.toString());

    }

    public String getRealTimeWeatherByPoint(String lng, String lat, String param) {
        String jsonString = getTenDaysForecastByPoint(lng, lat);
        JSONObject jsonObj = new JSONObject(jsonString);
        JSONArray timeSeriesArr = jsonObj.getJSONArray("timeSeries");

        // Find now values
        JSONObject nowValue = null;
        for (int i = 0; i < timeSeriesArr.length(); i++) {
            JSONObject jsonReading = timeSeriesArr.getJSONObject(i);

            String jsonDateTime = jsonReading.getString("validTime");
            ZonedDateTime zonedDate = ZonedDateTime.parse(jsonDateTime);

            LocalDateTime now = LocalDateTime.now();

            if (zonedDate.toLocalDate().equals(now.toLocalDate()) &&
                    zonedDate.getHour() == now.getHour()) {
                nowValue = timeSeriesArr.getJSONObject(i);
                break;
            }
        }

        // Find param values in now values
        if (nowValue != null) {
            JSONArray paramArr = nowValue.getJSONArray("parameters");
            for (int i = 0; i < paramArr.length(); i++) {
                JSONObject jsonReading = paramArr.getJSONObject(i);
                if (jsonReading.getString("name").equals(param)) {
                    return jsonReading.toString();
                }
            }
        }

        // Return null if no now values or no matching param
        return null;
    }

}
