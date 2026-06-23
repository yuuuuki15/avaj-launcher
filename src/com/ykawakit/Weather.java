package com.ykawakit;

public enum Weather {
    SUN(0),
    RAIN(1),
    FOG(2),
    SNOW(3);

    private final int id;

    private Weather(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
