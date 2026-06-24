package com.ykawakit;

abstract class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    public Aircraft() {}

    public Aircraft(String name, Coordinates coordinates) {
        this.id = UniqueIdFactory.getInstance().nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    void updateCoordinates(int longitude, int latitude, int height) {
        Coordinates newCoordinates = new Coordinates(this.coordinates.getLongitude() + longitude, this.coordinates.getLatitude() + latitude, this.coordinates.getHeight() + height);
        this.coordinates = newCoordinates;
    }
}