
import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private final List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable observer) {
        observers.add(observer);
    }

    public void unregister(Flyable observer) {
        observers.remove(observer);
    }

    protected void conditionChanged() {
        List<Flyable> copy = new ArrayList<>(observers);
        for (Flyable observer : copy) {
            observer.updateConditions();
        }
    }
}
