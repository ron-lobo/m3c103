package org.ron.m3.my1stOOP;

import org.ron.m3.my1stOOP.pets.Bird;
import org.ron.m3.my1stOOP.pets.Cat;
import org.ron.m3.my1stOOP.pets.Dog;
import org.ron.m3.my1stOOP.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PetsApp {

    public static void main(String[] args) {
        PetsApp petsApp = new PetsApp();
        petsApp.testPetsClasses();
    }

    private void testPetsClasses() {
//        Pet[] pets = createPets();

        List<Pet> pets = createPetList();
        System.out.println("Number of pets: " + pets.size());
        for (Pet pet : pets) {
            System.out.println(pet);
        }
        System.out.println();

        exercisePets(pets);
        System.out.println();

        playWithPets(pets);
        System.out.println();

        // sort by "natural order"
        Collections.sort(pets);
        System.out.println("sorted by: age, size, isMale, etc");
        for (Pet pet : pets) {
            System.out.println(pet);
        }

//        Collections.sort(pets, new BreedComparator());
        pets.sort(new BreedComparator());
        System.out.println("sorted by: breed");
        for (Pet pet : pets) {
            System.out.println(pet);
        }

        Collections.sort(pets, new NameComparator());
//        Collections.reverse(pets);
        System.out.println("sorted by: name");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    private class BreedComparator implements Comparator<Pet> {
        public int compare(Pet p1, Pet p2) {
            return p1.getBreed().compareTo(p2.getBreed());
        }
    }

    private class NameComparator implements Comparator<Pet> {
        public int compare(Pet p1, Pet p2) {
            return -(p1.getName().compareTo(p2.getName()));
        }
    }

    private void playWithPets(List<Pet> pets) {
        for (Pet pet : pets) {
            pet.playWith();
        }
    }

    private void exercisePets(List<Pet> pets) {
        for (Pet pet : pets) {
            pet.getExercise();
        }
    }

    private Pet[] createPets() {
        Dog dog0 = new Dog("Fido", "Collie", 3, 'L', true);
        Dog dog1 = new Dog("Rovette", "Labrador", 1, 'S', false);
        Dog dog2 = new Dog("Champ", "German Shepherd", 10, 'L', true, true);

        Cat cat0 = new Cat("Tiddles", "Tabby", 3, 'L', true);
        Cat cat1 = new Cat("Kitty", "Siamese", 1, 'S', false);

        Bird bird0 = new Bird("Birdy", "Finch", 2, 'S', false);
        Bird bird1 = new Bird("Tweety", "Canary", 4, 'S', true);

        return new Pet[]{dog0, dog1, dog2, cat0, cat1, bird0, bird1};
    }

    private List<Pet> createPetList() {
        List<Pet> petList = new ArrayList<>();
        addDogs(petList);
        addCats(petList);
        addBirds(petList);
        addDogs(petList);
        return petList;
    }

    private void addDogs(List<Pet> petList) {
        Dog dog0 = new Dog("Fido", "Collie", 3, 'L', true);
        Dog dog1 = new Dog("Rovette", "Labrador", 1, 'S', false);
        Dog dog2 = new Dog("Champ", "German Shepherd", 10, 'L', true, true);
        addNonDuplicate(petList, dog0);
        addNonDuplicate(petList, dog1);
        addNonDuplicate(petList, dog2);
    }

    private void addCats(List<Pet> petList) {
        Cat cat0 = new Cat("Tiddles", "Tabby", 3, 'L', true);
        Cat cat1 = new Cat("Kitty", "Siamese", 1, 'S', false);
        addNonDuplicate(petList, cat0);
        addNonDuplicate(petList, cat1);
    }

    private void addBirds(List<Pet> petList) {
        Bird bird0 = new Bird("Birdy", "Finch", 2, 'S', false);
        Bird bird1 = new Bird("Tweety", "Canary", 4, 'S', true);
        petList.add(bird0);
        petList.add(bird1);
    }

    private void addNonDuplicate(List<Pet> petList, Pet pet) {
        if (petList.contains(pet)) {
            System.out.println("petlist already contains " + pet);
        } else {
            petList.add(pet);
        }
    }
}
