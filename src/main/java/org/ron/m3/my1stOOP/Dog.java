package org.ron.m3.my1stOOP;

public class Dog extends Pet {

    private boolean isTrained;

    public Dog(String name, String breed, int age, char size, boolean isMale) {
        super(name, breed, age, size, isMale);
        this.isTrained = false;
    }

    public Dog(String name, String breed, int age, char size, boolean isMale, boolean isTrained) {
        super(name, breed, age, size, isMale);
        this.isTrained = isTrained;
    }

    public void getExercise() {
        walkDog(30);
    }

    public void walkDog(int minutes) {
        System.out.println("About to take " + getName() + " for walkies");
        if (minutes > 10) {
            runAround();
        }
        System.out.println("returned from " + minutes + " mins walk with " + getName());
        System.out.println();
    }

    public void runAround() {
        System.out.println(getName() + " runs around");
    }

    public void expressJoy() {
        System.out.println(getName() + " wags tail");
    }

    @Override
    public void playWith() {
        System.out.println("playing fetch with " + getName());
        expressJoy();
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }
}
