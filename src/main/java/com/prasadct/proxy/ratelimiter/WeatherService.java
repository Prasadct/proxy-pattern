package com.prasadct.proxy.ratelimiter;

// Subject Interface
public interface WeatherService {
    String getWeatherData(String location) throws Exception;
}
