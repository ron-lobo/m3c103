package org.ron.m3;

public class TempConverter {

    public static void main(String[] args) {

        TempConverter tc = new TempConverter();

        System.out.println("32F = " + tc.convertF2C(32) + "C");
        System.out.println("212F = " + tc.convertF2C(212) + "C");

        System.out.println("0C = " + tc.convertC2F(0) + "F");
        System.out.println("100C = " + tc.convertC2F(100) + "F");
    }


    private double convertF2C(double f) {
        return (f - 32) * 5/9;
    }

    private double convertC2F(double c) {
        return c * 9/5 +32;
    }
}
