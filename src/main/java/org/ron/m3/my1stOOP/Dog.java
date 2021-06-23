package org.ron.m3.my1stOOP;

public class Dog {

    private String name;
    private String breed;
    private int age;
    private char size; // S/M/L
    private boolean isMale;

//    public Dog() {
//        System.out.println("Creating new dog");
//    }

    public Dog(String name, String breed, int age, char size, boolean isMale) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.size = size;
        this.isMale = isMale;
    }

    public void walkDog(int minutes) {
        System.out.println("About to take " + name + " for walkies");
        System.out.println("returned from " + minutes + " mins walk with " + getName());
        System.out.println();
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

    public void setBreed(String breed) {
        this.breed = breed;
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
