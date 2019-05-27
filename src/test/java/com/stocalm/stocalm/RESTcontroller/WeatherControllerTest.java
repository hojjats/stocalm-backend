package com.stocalm.stocalm.RESTcontroller;

import com.stocalm.stocalm.Models.Weather;
import com.stocalm.stocalm.Service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherControllerTest {

    @InjectMocks
    WeatherController weatherController;

    @Mock
    WeatherService weatherService;

    @Test
    void getRealTimeWeatherByPoint() {
        when(weatherService.getRealTimeWeatherByPoint(anyString(), anyString())).thenReturn(new Weather(23, "iconUrlTest"));
        Weather returnedWeather = weatherController.getRealTimeWeatherByPoint("59", "18");
        verify(weatherService).getRealTimeWeatherByPoint(anyString(), anyString());
    }

    @Test
    void getForecastByPoint() {
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(new Weather(20, "imgUrlTest"));
        when(weatherService.getForecastByPoint(anyString(), anyString())).thenReturn(weatherList);

        weatherController.getForecastByPoint("59", "18");
        verify(weatherService).getForecastByPoint(anyString(), anyString());
    }
}