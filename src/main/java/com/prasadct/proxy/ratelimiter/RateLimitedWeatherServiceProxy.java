package com.prasadct.proxy.ratelimiter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RateLimitedWeatherServiceProxy implements WeatherService {
    private final WeatherService realWeatherService;
    private final int maxRequestsPerMinute;
    private final Map<String, UserRequestInfo> userRequestsMap;

    public RateLimitedWeatherServiceProxy(WeatherService realWeatherService, int maxRequestsPerMinute) {
        this.realWeatherService = realWeatherService;
        this.maxRequestsPerMinute = maxRequestsPerMinute;
        this.userRequestsMap = new HashMap<>();
    }

    @Override
    public String getWeatherData(String location) throws Exception {
        String userId = getCurrentUserId(); // In a real app, this would be from authentication

        if (isRateLimitExceeded(userId)) {
            throw new Exception("Rate limit exceeded. Try again later.");
        }

        // If rate limit is not exceeded, delegate to the real service
        return realWeatherService.getWeatherData(location);
    }

    private boolean isRateLimitExceeded(String userId) {
        LocalDateTime currentTime = LocalDateTime.now();

        // If this is a new user or the tracking info has expired, create new tracking info
        if (!userRequestsMap.containsKey(userId) ||
                userRequestsMap.get(userId).getWindowStartTime().plusMinutes(1).isBefore(currentTime)) {

            userRequestsMap.put(userId, new UserRequestInfo(currentTime));
            return false;
        }

        // Get existing user info and increment request count
        UserRequestInfo userInfo = userRequestsMap.get(userId);
        userInfo.incrementRequestCount();

        // Check if the user has exceeded the rate limit
        return userInfo.getRequestCount() > maxRequestsPerMinute;
    }

    private String getCurrentUserId() {
        // In a real application, this would get the authenticated user's ID
        // For this example, we'll just return a mock ID
        return "user-123";
    }

    // Helper class to track user requests
    private static class UserRequestInfo {
        private final LocalDateTime windowStartTime;
        private int requestCount;

        public UserRequestInfo(LocalDateTime windowStartTime) {
            this.windowStartTime = windowStartTime;
            this.requestCount = 1; // First request
        }

        public void incrementRequestCount() {
            requestCount++;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public LocalDateTime getWindowStartTime() {
            return windowStartTime;
        }
    }
}