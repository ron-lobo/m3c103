package org.ron.m3.spring.example1;

import java.util.Random;

public class DepA {

    private static final String AUDIENCE0 = "world";
    private static final String AUDIENCE1 = "c103";

    private final Random random = new Random();

    public String getAudience() {
        return random.nextBoolean() ? AUDIENCE0 : AUDIENCE1;
    }
}
