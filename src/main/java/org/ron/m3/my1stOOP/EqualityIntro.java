package org.ron.m3.my1stOOP;

import org.ron.m3.my1stOOP.pets.Bird;
import org.ron.m3.my1stOOP.pets.Cat;
import org.ron.m3.my1stOOP.pets.Dog;
import org.ron.m3.my1stOOP.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class EqualityIntro {

    public static void main(String[] args) {
        EqualityIntro equalityIntro = new EqualityIntro();
        equalityIntro.test0();
        equalityIntro.test1();
        equalityIntro.test2();
    }

    private void test0() {
        System.out.println("\ntest0");
        List<Pet> pets = readPetsFromDB();

        Dog myDog = getUserInput();

        if (pets.contains(myDog)) {
            System.out.println("animal already in pets list");
        } else {
            System.out.println("adding animal to pets list");
            pets.add(myDog);
        }
    }

    private Dog getUserInput() {
        return new Dog("Donald", null, 3, 'L', true);
    }

    private List<Pet> readPetsFromDB() {
        Dog dog0 = new Dog("Donald", "collie", 3, 'L', true);
        Dog dog1 = new Dog("Donald", null, 3, 'L', true);
        Cat cat1 = new Cat("Donald", null, 3, 'L', true);
        Bird bird1 = new Bird("Donald", null, 3, 'L', true);
        List<Pet> pets = new ArrayList<>();
        pets.add(dog0);
        pets.add(dog1);
        pets.add(cat1);
        pets.add(bird1);
        return pets;
    }

    private void test1() {
        System.out.println("\ntest1");
        Dog dog0 = new Dog("Fido", "Collie", 3, 'L', true);
        Dog dog1 = new Dog("Fido", "Collie", 3, 'L', true);
        Cat cat1 = new Cat("Fido", "Collie", 3, 'L', true);

//        dog0.setAge(5);
//        dog1.setName("Champ");

        System.out.println("dog0: " + dog0);
        System.out.println("dog1: " + dog1);

        System.out.println("Equality Test: == operator : dogs are " + (dog0 == dog1 ? "the same" : "different"));

        testEquality(dog0, cat1);
        testEquality(dog0, dog1);
        dog1.setTrained(true);
        testEquality(dog0, dog1);
    }

    private void test2() {
        System.out.println("\ntest2");
        Dog dog0 = new Dog("Donald", "collie", 3, 'L', true);
        Dog dog1 = new Dog("Donald", null, 3, 'L', true);
        Dog dog2 = new Dog("Donald", "collie", 3, 'L', true);
        Dog dog3 = new Dog("Donald", null, 3, 'L', true);

        System.out.println(dog0.equals(dog1));  // false
        System.out.println(dog0.equals(dog2));  // true

        System.out.println(dog1.equals(dog2));  // false
        System.out.println(dog1.equals(dog3));  // true
    }

    private static void testEquality(Object obj1, Object obj2) {
        if (obj1.equals(obj2)) {
            System.out.println("the 2 objects are equals()");
        } else {
            System.out.println("the 2 objects are NOT equals()");
        }
    }
}
