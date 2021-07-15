package org.ron.m3.spring.example1;

public class HWServer {

    private final HWHelper hwHelper = new HWHelper();

    public static void main(String[] args) {
//        System.out.println("Hi world");
        HWServer hwServer = new HWServer();
        hwServer.sayHello();
    }

    private void sayHello() {
        hwHelper.sayHi();
    }
}
