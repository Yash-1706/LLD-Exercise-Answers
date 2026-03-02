package com.example.metrics;

import java.lang.reflect.Constructor;

// Tests blocking duplicate instances via reflection
// Throws an exception if the constructor is invoked again
public class ReflectionAttack {

    public static void main(String[] args) throws Exception {
        MetricsRegistry singleton = MetricsRegistry.getInstance();

        Constructor<MetricsRegistry> ctor = MetricsRegistry.class.getDeclaredConstructor();
        ctor.setAccessible(true);

        MetricsRegistry evil = ctor.newInstance();

        System.out.println("Singleton identity: " + System.identityHashCode(singleton));
        System.out.println("Evil identity     : " + System.identityHashCode(evil));
        System.out.println("Same object?      : " + (singleton == evil));
    }
}
