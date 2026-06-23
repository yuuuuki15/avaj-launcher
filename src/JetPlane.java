class JetPlane extends Aircraft {
    public JetPlane() {}

    public JetPlane(String name, int longitude, int latitude, int height) {
        super(name, longitude, latitude, height);
    }

    @Override public void updateConditions() {
        Weather weather = super.getWeather();
        if (null != weather) switch (weather) {
            case SUN:
                System.out.println("JetPlane#" + this.name + ": Let's enjoy the good weather!");
                updateCoordinates(2, 10, 2);
                break;
            case RAIN:
                System.out.println("JetPlane#" + this.name + ": Damn you rain!");
                updateCoordinates(0, 5, 0);
                break;
            case FOG:
                System.out.println("JetPlane#" + this.name + ": I can't see anything! It's foggy");
                updateCoordinates(0, 1, 0);
                break;
            case SNOW:
                System.out.println("JetPlane#" + this.name + ": The winter is coming...");
                updateCoordinates(0, 0, -7);
                break;
            default:
                break;
        }
    }
}