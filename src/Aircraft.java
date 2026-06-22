abstract class Aircraft implements Flyable, WeatherObserver {
    protected String name;
    protected int longitude;
    protected int latitude;
    protected int height;

    public Aircraft() {}

    public Aircraft(String name, int longitude, int latitude, int height) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public void getInfo() {
        System.out.println("[Aircraft] " + this.name + " at (" + this.longitude + ", " + this.latitude + ", " + this.height + ")");
    }
}