package org.ron.m3.spring.example1;

public class HWHelper {

    private final HWService hwService = new HWService();

    public void sayHi() {
        hwService.makeGreeting("hi");
    }
}
