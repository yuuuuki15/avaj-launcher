public class Main {
    public static void main(String[] args) {
        Aircraft balloon = AircraftFactory.newAircraft("Balloon", "balloon", 100, 200, 90);
        Aircraft jetPlane = AircraftFactory.newAircraft("JetPlane", "jet", 400, 500, 60);
        WeatherTower weatherTower = WeatherTower.getInstance();
        weatherTower.register(balloon);
        weatherTower.register(jetPlane);

        weatherTower.changeWeather("SUN");

        weatherTower.unregister(balloon);
        weatherTower.unregister(jetPlane);

        weatherTower.changeWeather("RAIN");
    }
}