package org.ron.m3.spring.example2.example1;

import java.util.Random;

public class DepA implements AudienceProvider {

    private static final String AUDIENCE0 = "world";
    private static final String AUDIENCE1 = "c103";

    private final Random random = new Random();

    private String audience = random.nextBoolean() ? AUDIENCE0 : AUDIENCE1;

    @Override
    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
