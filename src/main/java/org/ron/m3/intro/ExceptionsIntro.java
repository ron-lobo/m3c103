package org.ron.m3.intro;

public class ExceptionsIntro {

    public static void main(String[] args) {
        ExceptionsIntro exceptionsIntro = new ExceptionsIntro();
        int i = exceptionsIntro.test1();
        int j = exceptionsIntro.test2(i);
        System.out.println("program terminates normally: j=" + j);
    }

    private int test1() {
        try {
            System.out.printf("fnX() = %d\n", fnX(12, 10));
            System.out.printf("fnX() = %d\n", fnX(12, 6));
            System.out.printf("fnY() = %d\n", fnY(12, -1));
            System.out.printf("fnY() = %d\n", fnY(212, 6));
            return fnX(3, 0);
        } catch (MyException e) {
            System.err.println("error in test1(): " + e.getMessage());
            e.printStackTrace();
            return -1;
        } catch (ArithmeticException e) {
            System.err.println("error in test1() (div by zero): " + e.getMessage());
            e.printStackTrace();
            return -2;
        } finally {
            System.out.println("finally");
        }
    }

    private int test2(int i) {
        System.out.println("test2()");
        return i + 1;
    }

    private int fnX(int a, int b) /* throws ArithmeticException */ {
        return a / b;
    }

    private int fnY(int a, int b) throws MyException {
        int result = a - b;
        if (result < 10) {
            throw new MyException("result less than 10!");
        }
        return result;
    }
}
