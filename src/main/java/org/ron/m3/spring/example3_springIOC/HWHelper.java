package org.ron.m3.spring.example3_springIOC;

public class HWHelper implements Helper {

    private final GreetingService greetingService;

    public HWHelper(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void sayHi() {
        greetingService.makeGreeting("hi");
    }
}
