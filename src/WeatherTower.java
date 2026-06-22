
import java.util.ArrayList;
import java.util.List;

public class WeatherTower {
    private final List<WeatherObserver> observers;

    public WeatherTower() {
        observers = new ArrayList<>();
    }

    public void register(WeatherObserver observer) {
        observers.add(observer);
    }

    public void unregister(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void changeWeather(String weather) {
        for (WeatherObserver observer : observers) {
            observer.updateConditions(weather);
        }
    }
}
