package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Models.Weather;
import com.stocalm.stocalm.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/now/lng/{lng}/lat/{lat}")
    public Weather getRealTimeWeatherByPoint(@PathVariable String lng, @PathVariable String lat) {
        return weatherService.getRealTimeWeatherByPoint(lng, lat);
    }

    @GetMapping("/forecast/lng/{lng}/lat/{lat}")
    public List<Weather> getForecastByPoint(@PathVariable String lng, @PathVariable String lat) {
        return weatherService.getForecastByPoint(lng, lat);
    }


}
