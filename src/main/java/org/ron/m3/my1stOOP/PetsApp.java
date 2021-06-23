package org.ron.m3.my1stOOP;

public class PetsApp {

    public static void main(String[] args) {

        Dog fido = new Dog("Fido", "Collie", 3, 'L', true);
        Dog dog1 = new Dog("Rovette", "Labrador", 1, 'S', false);
        Dog dog2 = new Dog("Champ", "German Shepherd", 10, 'L', true);

        // dog1.setMale(true);
        dog2.setAge(dog2.getAge() + 1);

        fido.walkDog(30);
        dog1.walkDog(45);
        dog2.walkDog(20);
    }
}
