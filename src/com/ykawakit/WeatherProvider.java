package com.ykawakit;

public class WeatherProvider {
    private static final String[] weather = {
        Weather.SUN.toString(),
        Weather.RAIN.toString(),
        Weather.FOG.toString(),
        Weather.SNOW.toString(),
    };

    private WeatherProvider(){}

    public static String getCurrentWeather(Coordinates coordinates) {
        int sum = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[Math.abs(sum) % weather.length];
    }
}
