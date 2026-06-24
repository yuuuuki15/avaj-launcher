package com.ykawakit;

import java.util.concurrent.atomic.AtomicLong;

public class UniqueIdFactory {
    private static final UniqueIdFactory INSTANCE = new UniqueIdFactory();

    private final AtomicLong counter = new AtomicLong(1);

    private UniqueIdFactory() {}

    public static UniqueIdFactory getInstance() {
        return INSTANCE;
    }

    public long nextId() {
        return counter.getAndIncrement();
    }
}
