package org.ron.m3.my1stOOP;

import org.ron.m3.my1stOOP.pets.*;

public class PetsApp {

    public static void main(String[] args) {

        Pet[] pets = createPets();
        for (Pet pet : pets) {
            System.out.println(pet);
        }

        exercisePets(pets);
        System.out.println();

        playWithPets(pets);
        System.out.println();
    }

    private static void playWithPets(Pet[] pets) {
        for (Pet pet : pets) {
            pet.playWith();
        }
    }

    private static void exercisePets(Pet[] pets) {
        for (Pet pet : pets) {
            pet.getExercise();
        }
    }

    private static Pet[] createPets() {
        Dog dog0 = new Dog("Fido", "Collie", 3, 'L', true);
        Dog dog1 = new Dog("Rovette", "Labrador", 1, 'S', false);
        Dog dog2 = new Dog("Champ", "German Shepherd", 10, 'L', true, true);

        Cat cat0 = new Cat("Tiddles", "Tabby", 3, 'L', true);
        Cat cat1 = new Cat("Kitty", "Siamese", 1, 'S', false);

        Bird bird0 = new Bird("Birdy", "Finch", 2, 'S', false);
        Bird bird1 = new Bird("Tweety", "Canary", 4, 'S', true);

        return new Pet[]{dog0, dog1, dog2, cat0, cat1, bird0, bird1};
    }
}
