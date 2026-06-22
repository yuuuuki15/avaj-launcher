public class AircraftFactory {
    public static Aircraft newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (null == type) {
            System.err.println("Please specify type");
            return null;
        } else switch (type) {
            case "Balloon":
                return new Balloon(name, longitude, latitude, height);
            case "JetPlane":
                return new JetPlane(name, longitude, latitude, height);
            case "Helicopter":
                return new Helicopter(name, longitude, latitude, height);
            default:
                System.err.println("type doesn't match any Aircraft");
                return null;
        }
    }
}
