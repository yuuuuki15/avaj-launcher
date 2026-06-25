package com.ykawakit;

public class WeatherProvider {
    private static final String[] weather = {
        Weather.SNOW.toString(),
        Weather.SUN.toString(),
        Weather.RAIN.toString(),
        Weather.FOG.toString(),
    };

    private WeatherProvider(){}

    public static String getCurrentWeather(Coordinates coordinates) {
        if (coordinates.getLongitude() > 180 || coordinates.getLatitude() > 90) {
            return Weather.SNOW.toString();
        }
        int sum = (coordinates.getLongitude() % 2 + coordinates.getLatitude() % 3) * (coordinates.getHeight() % 3);
        return weather[Math.abs(sum) % weather.length];
    }
}
