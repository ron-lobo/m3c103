package org.ron.m3.spring.example2;

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
