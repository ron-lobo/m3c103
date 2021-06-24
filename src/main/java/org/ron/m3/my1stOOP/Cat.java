package org.ron.m3.my1stOOP;

public class Cat extends Pet {

    public Cat(String name, String breed, int age, char size, boolean isMale) {
        super(name, breed, age, size, isMale);
    }

    public void beCatish() {
        System.out.println(getName() + " pays no attention to owner");
        System.out.println(getName() + " glances disdainfully at owner");
        System.out.println();
    }

    public void chaseBirds() {
        System.out.println(getName() + " chases birds");
    }

    public void expressJoy() {
        System.out.println(getName() + " purrs");
    }

    public void playWith() {
        System.out.println("stroke " + getName());
        expressJoy();
    }
}
