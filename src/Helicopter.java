public class Helicopter extends Aircraft {
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    void checkLanded() {
        if (coordinates.getHeight() == 0) {
            System.out.println("Helicopter#" + this.name + ": Landed.");
            this.weatherTower.unregister(this);
        }
    }

    @Override public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        if (null != weather) switch (weather) {
            case "SUN":
                System.out.println("Helicopter#" + this.name + ": Let's enjoy the good weather!");
                updateCoordinates(10, 0, 2);
                break;
            case "RAIN":
                System.out.println("Helicopter#" + this.name + ": Damn you rain!");
                updateCoordinates(5, 0, 0);
                break;
            case "FOG":
                System.out.println("Helicopter#" + this.name + ": I can't see anything! It's foggy");
                updateCoordinates(2, 0, 0);
                break;
            case "SNOW":
                System.out.println("Helicopter#" + this.name + ": The winter is coming...");
                updateCoordinates(0, 0, -12);
                break;
            default:
                break;
        }
        checkLanded();
    }
}
