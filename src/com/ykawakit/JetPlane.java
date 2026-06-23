package com.ykawakit;

class JetPlane extends Aircraft {
    public JetPlane() {}

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    void checkLanded() {
        if (coordinates.getHeight() == 0) {
            System.out.println("JetPlane#" + this.name + ": Landed.");
            this.weatherTower.unregister(this);
        }
    }

    @Override public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        if (null != weather) switch (weather) {
            case "SUN":
                System.out.println("JetPlane#" + this.name + ": Let's enjoy the good weather!");
                updateCoordinates(2, 10, 2);
                break;
            case "RAIN":
                System.out.println("JetPlane#" + this.name + ": Damn you rain!");
                updateCoordinates(0, 5, 0);
                break;
            case "FOG":
                System.out.println("JetPlane#" + this.name + ": I can't see anything! It's foggy");
                updateCoordinates(0, 1, 0);
                break;
            case "SNOW":
                System.out.println("JetPlane#" + this.name + ": The winter is coming...");
                updateCoordinates(0, 0, -7);
                break;
            default:
                break;
        }
        checkLanded();
    }
}