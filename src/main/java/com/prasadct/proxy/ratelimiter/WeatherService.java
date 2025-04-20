package com.prasadct.proxy.ratelimiter;

public interface WeatherService {
    String getWeatherData(String location) throws Exception;
}
