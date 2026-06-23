package com.ykawakit;

class Balloon extends Aircraft {
    public Balloon() {}

    public Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    void checkLanded() {
        if (coordinates.getHeight() == 0) {
            System.out.println("Balloon#" + this.name + ": Landed.");
            this.weatherTower.unregister(this);
        }
    }

    @Override public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        if (null != weather) switch (weather) {
            case "SUN":
                System.out.println("Balloon#" + this.name + ": Let's enjoy the good weather!");
                updateCoordinates(2, 0, 4);
                break;
            case "RAIN":
                System.out.println("Balloon#" + this.name + ": Damn you rain!");
                updateCoordinates(0, 0, -5);
                break;
            case "FOG":
                System.out.println("Balloon#" + this.name + ": I can't see anything! It's foggy");
                updateCoordinates(0, 0, -3);
                break;
            case "SNOW":
                System.out.println("Balloon#" + this.name + ": The winter is coming...");
                updateCoordinates(0, 0, -15);
                break;
            default:
                break;
        }
        checkLanded();
    }
}