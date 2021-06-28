package org.ron.m3.my1stOOP;

import org.ron.m3.my1stOOP.pets.Dog;

public class Test {

    public static void main(String[] args) {
        Dog dog0 = new Dog("Fido", "Collie", 3, 'L', true);
        Dog dog1 = new Dog("Fido", "Collie", 3, 'L', true);

//        dog0.setAge(5);
        dog1.setTrained(false);
//        dog1.setName("Champ");

        System.out.println("dog0: " + dog0);
        System.out.println("dog1: " + dog1);


        if (dog0 == dog1) {
            System.out.println("dogs are the same (==)");
        } else {
            System.out.println("dogs are different (!=)");
        }

        if (dog0.equals(dog1)) {
            System.out.println("dogs are equals()");
        } else {
            System.out.println("dogs are not equals()");
        }
    }
}
