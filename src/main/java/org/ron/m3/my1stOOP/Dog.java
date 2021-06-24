package org.ron.m3.my1stOOP;

public class Dog {

    private String name;
    private final String breed;
    private int age;
    private char size; // S/M/L
    private final boolean isMale;

    public Dog(String name, String breed, int age, char size, boolean isMale) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.size = size;
        this.isMale = isMale;
    }

    public void walkDog(int minutes) {
        System.out.println("About to take " + name + " for walkies");
        if (minutes > 10) {
            runAround();
        }
        System.out.println("returned from " + minutes + " mins walk with " + getName());
        System.out.println();
    }

    public void runAround() {
        System.out.println(name + " runs around");
    }

    public void wagTail() {
        System.out.println(name + " wags tail");
    }

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
