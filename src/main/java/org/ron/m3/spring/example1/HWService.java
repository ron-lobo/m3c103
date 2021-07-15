package org.ron.m3.spring.example1;

public class HWService {

    private DepA depA = new DepA();

    private final String audience = depA.getAudience();

    public void makeGreeting(String salutation) {
        System.out.printf("%s %s%n", salutation, audience);
    }
}
