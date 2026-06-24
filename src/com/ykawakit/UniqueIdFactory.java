package com.ykawakit;

public class UniqueIdFactory {
    private static final UniqueIdFactory INSTANCE = new UniqueIdFactory();

    private long counter = 0;

    private UniqueIdFactory() {}

    public static UniqueIdFactory getInstance() {
        return INSTANCE;
    }

    public long nextId() {
        return ++counter;
    }
}
