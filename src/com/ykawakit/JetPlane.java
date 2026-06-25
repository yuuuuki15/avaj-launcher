package com.ykawakit;

class JetPlane extends Aircraft {
    public JetPlane() {}

    public JetPlane(long id, String name, Coordinates coordinates) {
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
                updateCoordinates(0, 10, 2);
                break;
            case "RAIN":
                describe();
                System.out.println(": Damn you rain!");
                updateCoordinates(0, 5, 0);
                break;
            case "FOG":
                describe();
                System.out.println(": I can't see anything! It's foggy");
                updateCoordinates(0, 1, 0);
                break;
            case "SNOW":
                describe();
                System.out.println(": The winter is coming...");
                updateCoordinates(0, 0, -7);
                break;
            default:
                break;
        }
        checkLanded();
    }

    @Override public void describe() {
        System.out.print("JetPlane#" + name + "(" + id + ")");
    }
}