package org.ron.m3.my1stOOP.pets;

public abstract class Pet implements Comparable<Pet> {

    private String name;
    private final String breed;
    private int age;
    private char size; // S/M/L
    private final boolean isMale;

    public Pet(String name, String breed, int age, char size, boolean isMale) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.size = size;
        this.isMale = isMale;
    }

    public abstract void expressJoy();

    public void playWith() {
        System.out.println("stroke " + getName());
        expressJoy();
    }

    public void getExercise() {
        System.out.println(name + " exercises by itself");
    }

    // sort by age, size, gender, breed, name
    public int compareTo(Pet pet) {
        int result = Integer.compare(age, pet.age);
        if (result == 0) {
            result = Character.compare(size, pet.size);
            if (result == 0) {
                result = Boolean.compare(isMale, pet.isMale);
                if (result == 0) {
                    result = breed.compareTo(pet.breed);
                    if (result == 0) {
                        result = name.compareTo(pet.name);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != getClass())
            return false;
        Pet p = (Pet) obj;
        return (name == p.name || (name != null && name.equals(p.name))) &&
                (breed == p.breed || (breed != null && breed.equals(p.breed))) &&
                age == p.age &&
                size == p.size &&
                isMale == p.isMale;
    }

    @Override
    public int hashCode() {
        // return 0;
        // return name.hashCode() + breed.hashCode() + age + size + Boolean.valueOf(isMale).hashCode();

        final int PRIME = 97;
        int result = name.hashCode();
        result = result * PRIME + breed.hashCode();
        result = result * PRIME + ((Integer) age).hashCode();
        result = result * PRIME + ((Character) size).hashCode();
        result = result * PRIME + ((Boolean) isMale).hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pet {" +
                "name=" + getName() +
                ", breed=" + getBreed() +
                ", age=" + getAge() +
                ", size=" + getSize() +
                ", isMale=" + isMale +
                "}";
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
