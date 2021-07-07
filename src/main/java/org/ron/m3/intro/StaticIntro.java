package org.ron.m3.intro;

import java.util.Collections;

import static java.lang.Math.*;

public class StaticIntro {

    // static members
    private static String s0;
    private static String s1;
    private static String s2 = "abc";
    private static String s3 = Collections.emptyList().toString();

    // constant
    private static final double PI = 3.1;

    // static initializer block
    static {
        try {
            // processing, method calls, etc
            s0 = "123";
            s1 = "xyz";
        } catch (Exception e) {
            // log exception
        }
    }

    // static inner class
    private static class X {
    }

    public static void main(String[] args) {
        // instantiate static inner classes
        X x = new X();
        InterfaceIntro.Bus bus = new InterfaceIntro.Bus();

        m1();
    }

    // static method
    public static void m1() {
        // static method calls
        double d0 = Math.sqrt(55);
        double d1 = Math.pow(9, 9);
        double d2 = Math.abs(d1);

        // using static imports
        double ds0 = sqrt(55);
        double ds1 = pow(9, 9);
        double ds2 = abs(d1);
    }
}
