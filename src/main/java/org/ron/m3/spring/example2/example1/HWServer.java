package org.ron.m3.spring.example2.example1;

public class HWServer {

    private final Helper helper;

    public static void main(String[] args) {
        AudienceProvider depA = new DepA();
        GreetingService hwService = new HWService(depA);
        HWServer hwServer = new HWServer(new HWHelper(hwService));
        hwServer.sayHello();
    }

    public HWServer(Helper helper) {
        this.helper = helper;
    }

    private void sayHello() {
        helper.sayHi();
    }
}
