package com.ykawakit;

public class Helicopter extends Aircraft {
    Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    void checkLanded() {
        if (coordinates.getHeight() == 0) {
            describe();
            System.out.println(": Landed.");
            this.weatherTower.unregister(this);
        }
    }

    @Override public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        if (null != weather) switch (weather) {
            case "SUN":
                describe();
                System.out.println(": Let's enjoy the good weather!");
                updateCoordinates(10, 0, 2);
                break;
            case "RAIN":
                describe();
                System.out.println(": Damn you rain!");
                updateCoordinates(5, 0, 0);
                break;
            case "FOG":
                describe();
                System.out.println(": I can't see anything! It's foggy");
                updateCoordinates(2, 0, 0);
                break;
            case "SNOW":
                describe();
                System.out.println(": The winter is coming...");
                updateCoordinates(0, 0, -12);
                break;
            default:
                break;
        }
        checkLanded();
    }

    @Override public void describe() {
        System.out.print("Helicopter#" + name + "(" + id + ")");
    }
}
