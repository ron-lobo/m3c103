package org.ron.m3.my1stOOP;

import org.ron.m3.my1stOOP.pets.Cat;
import org.ron.m3.my1stOOP.pets.Dog;

public class Test {

    public static void main(String[] args) {
        Dog dog0 = new Dog("Fido", "Collie", 3, 'L', true);
        Dog dog1 = new Dog("Fido", "Collie", 3, 'L', true);
        Cat cat1 = new Cat("Fido", "Collie", 3, 'L', true);

//        dog0.setAge(5);
//        dog1.setName("Champ");

        System.out.println("dog0: " + dog0);
        System.out.println("dog1: " + dog1);


        if (dog0 == dog1) {
            System.out.println("dogs are the same (==)");
        } else {
            System.out.println("dogs are different (!=)");
        }

        testEquality(dog0, dog1);
        dog1.setTrained(true);
        testEquality(dog0, dog1);
        testEquality(dog0, cat1);
    }

    private static void testEquality(Object obj1, Object obj2) {
        if (obj1.equals(obj2)) {
            System.out.println("the 2 objects are equals()");
        } else {
            System.out.println("the 2 objects are NOT equals()");
        }
    }
}
