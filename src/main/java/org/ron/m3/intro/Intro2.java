package org.ron.m3.intro;

public class Intro2 {

    public static void main(String[] args) {
        Intro2 intro2 = new Intro2();
        intro2.forLoop();
        intro2.whileLoop();
        intro2.doWhileLoop();
    }

    private void doWhileLoop() {
        int i = 0;
        do {
            System.out.println("do while loop 1: i=" + ++i);
        } while (i < 3);
        System.out.println();

        i = 0;
        do {
            System.out.println("do while loop 2: i=" + ++i);
            if (i == 5)
                break;
            boolean isEven = i%2==0;
            if (isEven)
                continue;
            System.out.println("do while loop 2: i is even: " + isEven);
            System.out.println("do while loop 2: i is odd: " + (i%2==1));
        } while (i < 4);
        System.out.println();

    }

    private void whileLoop() {
        int i = 0;
        while (i < 4) {
            System.out.println("while loop 1: i=" + ++i);
        }
        System.out.println();

        i = 0;
        while (true) {
            System.out.println("while loop 2: i=" + ++i);
            if (i == 3)
                break;
            boolean isEven = i%2==0;
            if (isEven)
                continue;
            System.out.println("while loop 2: i is even: " + isEven);
            System.out.println("while loop 2: i is odd: " + (i%2==1));
        }
        System.out.println();
    }

    private void forLoop() {
        for (int i = 0; i < 10; i++) System.out.println("for loop 1: i=" + i);
        System.out.println();

        for (int i = 10; i > 0; i--)
            System.out.println("for loop 2: i=" + i);
        System.out.println();

        String s = "c103";
        for (char c : s.toCharArray()) {
            System.out.println("for loop 3a: c=" + c);
        }
        System.out.println();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("for loop 3b: c=" + c);
        }
        System.out.println();

        int i = 123;
    }
}
