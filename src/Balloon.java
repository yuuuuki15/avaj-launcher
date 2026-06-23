class Balloon extends Aircraft {
    public Balloon() {}

    public Balloon(String name, int longitude, int latitude, int height) {
        super(name, longitude, latitude, height);
    }

    @Override public void updateConditions() {
        Weather weather = super.getWeather();
        if (null != weather) switch (weather) {
            case SUN:
                System.out.println("Balloon#" + this.name + ": Let's enjoy the good weather!");
                updateCoordinates(2, 0, 4);
                break;
            case RAIN:
                System.out.println("Balloon#" + this.name + ": Damn you rain!");
                updateCoordinates(0, 0, -5);
                break;
            case FOG:
                System.out.println("Balloon#" + this.name + ": I can't see anything! It's foggy");
                updateCoordinates(0, 0, -3);
                break;
            case SNOW:
                System.out.println("Balloon#" + this.name + ": The winter is coming...");
                updateCoordinates(0, 0, -15);
                break;
            default:
                break;
        }
    }
}