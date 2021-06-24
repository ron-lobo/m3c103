package org.ron.m3.my1stOOP;

public abstract class Pet {

    private String name;
    private final String breed;
    private int age;
    private char size; // S/M/L
    private final boolean isMale;

    public Pet(String name, String breed, int age, char size, boolean isMale) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.size = size;
        this.isMale = isMale;
    }

    public abstract void expressJoy();

    public abstract void playWith();

    public void getExercise() {
        System.out.println(name + " is too lazy to exercise");
    };

    @Override
    public String toString() {
        return "name=" + getName() +
                ", breed=" + getBreed() +
                ", age=" + getAge() +
                ", size=" + getSize() +
                ", isMale=" + isMale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public boolean isMale() {
        return isMale;
    }
}
