package org.ron.m3.my1stOOP;

public class PetsApp {

    public static void main(String[] args) {

        Dog[] dogs = createDogs();
        dogs[2].setAge(dogs[2].getAge() + 1);

        walkDogs(dogs);

        dogs[0].wagTail();
        dogs[2].wagTail();
        System.out.println();

        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }

    private static void walkDogs(Dog[] dogs) {
        dogs[0].walkDog(30);
        dogs[1].walkDog(45);
        dogs[2].walkDog(10);
    }

    private static Dog[] createDogs() {
        Dog dog0 = new Dog("Fido", "Collie", 3, 'L', true);
        Dog dog1 = new Dog("Rovette", "Labrador", 1, 'S', false);
        Dog dog2 = new Dog("Champ", "German Shepherd", 10, 'L', true);
//        Dog[] dogs = new Dog[]{dog0, dog1, dog2};
//        return dogs;
        return new Dog[]{dog0, dog1, dog2};
    }
}
