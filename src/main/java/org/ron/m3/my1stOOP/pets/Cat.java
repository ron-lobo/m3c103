package org.ron.m3.my1stOOP.pets;

public class Cat extends Pet {

    public Cat(String name, String breed, int age, char size, boolean isMale) {
        super(name, breed, age, size, isMale);
    }

    public void beCattish() {
        System.out.println(getName() + " pays no attention to owner");
        System.out.println(getName() + " glances disdainfully at owner");
    }

    public void getExercise() {
        System.out.println(getName() + " chases birds");
    }

    public void expressJoy() {
        System.out.println(getName() + " purrs");
        beCattish();
    }
}
