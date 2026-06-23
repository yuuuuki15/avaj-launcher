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

    Weather getWeather() {
        int sum = longitude + latitude + height;
        int tmp = Math.abs(sum) % 4;
        switch (tmp) {
            case 0:
                return Weather.SUN;
            case 1:
                return Weather.RAIN;
            case 2:
                return Weather.FOG;
            case 3:
                return Weather.SNOW;
            default:
                throw new AssertionError();
        }
    }

    void updateCoordinates(int longitude, int latitude, int height) {
        this.longitude += longitude;
        this.latitude += latitude;
        this.height += height;
    }
}