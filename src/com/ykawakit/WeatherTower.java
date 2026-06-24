package com.ykawakit;

public class WeatherTower extends Tower {
    public void register(Flyable observer) {
        if (observer != null) {
            super.register(observer);
            observer.registerTower(this);
            System.out.print("Tower says: ");
            observer.describe();
            System.out.println(" registered to weather tower.");
        }
    }

    public void unregister(Flyable observer) {
        if (observer != null) {
            super.unregister(observer);
            System.out.print("Tower says: ");
            observer.describe();
            System.out.println(" unregistered from weather tower.");
        }
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionChanged();
    }
}
