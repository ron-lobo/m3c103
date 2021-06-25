package org.ron.m3.my1stOOP.pets;

public class Bird extends Pet {

    public Bird(String name, String breed, int age, char size, boolean isMale) {
        super(name, breed, age, size, isMale);
    }

    @Override
    public void expressJoy() {
        System.out.println(getName() + " chirps/tweets");
    }
}
