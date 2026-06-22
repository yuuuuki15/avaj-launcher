public class Main {
    public static void main(String[] args) {
        Aircraft balloon = new Balloon("balloon", 100, 200, 90);
        Aircraft jetPlane = new JetPlane("jet", 400, 500, 600);
        WeatherTower weatherTower = new WeatherTower();
        weatherTower.register(balloon);
        weatherTower.register(jetPlane);

        weatherTower.changeWeather("SUN");

        weatherTower.unregister(balloon);
        weatherTower.unregister(jetPlane);

        weatherTower.changeWeather("RAIN");
    }
}