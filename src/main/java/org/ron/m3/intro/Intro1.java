package org.ron.m3.intro;

import org.ron.m3.TempConverter;

public class Intro1 extends TempConverter {

    public static void main(String[] args) {
        Intro1 intro1 = new Intro1();
//        intro1.convertF2C(123);
//        intro1.convert(true, 321);
//        intro1.getVal();
        intro1.testTC();
    }

    public void testTC() {
        Intro1 tcA = new Intro1();
        Intro1 tcB = tcA; // new Test01();

        System.out.println(tcA == tcB);
        System.out.println(tcA.equals(tcB));

    }

    public int getVal() {

        int i = 1;
        int j = i * 10;
        System.out.println(i);
        i++;
        i--;
        i *= 5;
        i = i + j;
        System.out.println(i);

        Integer a0 = new Integer(1);
        Integer a1 = 1;
        Integer a2 = a1;
        System.out.println("a1=" + a1);
        System.out.println("a2=" + a2);

        a1 = i;
        i = a1;
        i = a1.intValue();
        System.out.println("a1=" + a1);
        System.out.println("a2=" + a2);


        return i;
    }

}
