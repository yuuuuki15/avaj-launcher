public class AircraftFactory {
    private AircraftFactory() {}

    public static Aircraft newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (null == type) {
            System.err.println("Please specify type");
            return null;
        } else switch (type) {
            case "Balloon":
                return new Balloon(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            case "Helicopter":
                return new Helicopter(name, coordinates);
            default:
                System.err.println("type doesn't match any Aircraft");
                return null;
        }
    }
}
