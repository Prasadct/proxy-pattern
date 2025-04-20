# Java Proxy Pattern Examples

This repository contains practical implementations of the Proxy Design Pattern in Java. These examples accompany the blog post [Proxy Design Pattern in Java with Real-World Example](https://prasadct.com/java/proxy-design-pattern-in-java/) on [prasadct.com](https://prasadct.com/).

## Overview

The Proxy Pattern provides a surrogate or placeholder for another object to control access to it. This repository demonstrates two common implementations:

1. **API Rate Limiter Proxy** - Controls how many requests a client can make to a service within a time period
2. **Image Loading Proxy** - Demonstrates lazy loading of resource-intensive objects

## Project Structure
```
src/
├── main/
│   └── java/
│       └── com/
│           └── prasadct/
│               └── proxy/
│                   ├── ratelimiter/       # Rate Limiter Example
│                   │   ├── WeatherService.java
│                   │   ├── RealWeatherService.java
│                   │   ├── RateLimitedWeatherServiceProxy.java
│                   │   └── WeatherApp.java
│                   │
│                   └── imageloader/       # Image Loader Example
│                       ├── Image.java
│                       ├── RealImage.java
│                       ├── ProxyImage.java
│                       └── ImageViewer.java
```

## Examples

### 1. API Rate Limiter Proxy

This example demonstrates how to implement a proxy that limits the number of API requests a client can make within a specific time frame.

Key components:
- `WeatherService` - Interface defining the service API
- `RealWeatherService` - The actual implementation that gets weather data
- `RateLimitedWeatherServiceProxy` - A proxy that enforces rate limiting
- `WeatherApp` - Client code demonstrating how the proxy works

### 2. Image Loading Proxy
This example shows how to use the Virtual Proxy pattern to delay loading resource-intensive objects until they're actually needed.
   
Key components:
- `Image `- Interface for the image operations
- `RealImage` - Resource-intensive implementation that loads and displays images
- `ProxyImage` - A proxy that defers loading the RealImage until necessary
- `ImageViewer` - Client code demonstrating lazy loading