package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Metrics registry implemented using the static holder pattern
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Long> counters = new HashMap<>();

    // Tracks if an instance already exists to block reflection
    private static boolean created = false;

    private MetricsRegistry() {
        // Prevent reflection from creating a duplicate instance
        if (created) {
            throw new IllegalStateException("Singleton already exist; use getInstance()");
        }
        created = true;
    }

    // Inner class loaded lazily by the JVM; provides thread safety
    private static class Holder {
        static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    // Return the existing instance during deserialization
    @Serial
    private Object readResolve() {
        return getInstance();
    }
}
