
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
        System.out.println("aircraft was registered.");
    }

    public void unregister(WeatherObserver observer) {
        observers.remove(observer);
        System.out.println("aircraft was unregistered.");
    }

    public void changeWeather() {
        for (WeatherObserver observer : observers) {
            observer.updateConditions();
        }
    }
}
