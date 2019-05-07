package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/now/lng/{lng}/lat/{lat}/param/{param}")
    public String getRealTimeWeatherByPoint(@PathVariable String lng, @PathVariable String lat, @PathVariable String param) {
        return weatherService.getRealTimeWeatherByPoint(lng, lat, param);
    }


}
