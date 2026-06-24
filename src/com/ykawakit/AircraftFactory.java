package com.ykawakit;

public class AircraftFactory {
    private AircraftFactory() {}

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        long id = UniqueIdFactory.getInstance().nextId();
        if (null == type) {
            System.err.println("Please specify type");
            return null;
        } else switch (type) {
            case "Balloon":
                return new Balloon(id, name, coordinates);
            case "JetPlane":
                return new JetPlane(id, name, coordinates);
            case "Helicopter":
                return new Helicopter(id, name, coordinates);
            default:
                System.err.println("type doesn't match any Aircraft");
                return null;
        }
    }
}
