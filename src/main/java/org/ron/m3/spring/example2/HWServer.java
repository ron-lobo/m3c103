package org.ron.m3.spring.example2;

public class HWServer {

    private final Helper helper;

    public static void main(String[] args) {
        AudienceProvider audienceProvider = new DepA();
        GreetingService greetingService = new HWService(audienceProvider);
        Helper helper = new HWHelper(greetingService);
        HWServer hwServer = new HWServer(helper);
        hwServer.sayHello();
    }

    public HWServer(Helper helper) {
        this.helper = helper;
    }

    private void sayHello() {
        helper.sayHi();
    }
}
