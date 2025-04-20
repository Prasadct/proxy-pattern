package com.prasadct.proxy.ratelimiter;

public class WeatherApp {
    public static void main(String[] args) {
        // Create the real service
        WeatherService realService = new RealWeatherService();

        // Create the proxy with a limit of 3 requests per minute
        WeatherService proxy = new RateLimitedWeatherServiceProxy(realService, 3);

        try {
            // Try making several requests
            System.out.println("First request: " + proxy.getWeatherData("Bangalore"));
            System.out.println("Second request: " + proxy.getWeatherData("Mumbai"));
            System.out.println("Third request: " + proxy.getWeatherData("Delhi"));

            // This request should trigger the rate limit
            System.out.println("Fourth request: " + proxy.getWeatherData("Chennai"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}