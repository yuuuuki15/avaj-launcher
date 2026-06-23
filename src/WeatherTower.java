

public class WeatherTower extends Tower {
    WeatherTower() {
    }

    public void register(Flyable observer) {
        if (observer != null) {
            super.register(observer);
            observer.registerTower(this);
            System.out.println("aircraft was registered.");
        }
    }

    public void unregister(Flyable observer) {
        if (observer != null) {
            super.unregister(observer);
            System.out.println("aircraft was unregistered.");
        }
    }

    String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionChanged();
    }
}
