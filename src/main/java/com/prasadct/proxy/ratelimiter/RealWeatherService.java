package com.prasadct.proxy.ratelimiter;

// Real Subject
public class RealWeatherService implements WeatherService {
    @Override
    public String getWeatherData(String location) throws Exception {
        // In a real application, this would call an external API
        System.out.println("Fetching weather data for " + location + " from external API");

        // Simulate API call with a delay
        Thread.sleep(1000);

        // Return mock weather data
        return "Temperature: 25°C, Condition: Sunny, Location: " + location;
    }
}
