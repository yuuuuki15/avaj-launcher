
import java.util.ArrayList;
import java.util.List;

public class WeatherTower {
    private static final WeatherTower INSTANCE = new WeatherTower();
    private final List<WeatherObserver> observers;

    private  WeatherTower() {
        observers = new ArrayList<>();
    }

    public static WeatherTower getInstance() {
        return INSTANCE;
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
