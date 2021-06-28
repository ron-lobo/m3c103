package org.ron.m3.collections;

import org.ron.m3.my1stOOP.pets.Bird;
import org.ron.m3.my1stOOP.pets.Cat;
import org.ron.m3.my1stOOP.pets.Dog;
import org.ron.m3.my1stOOP.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsIntro {

    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
        ci.arrays();
        ci.lists();
    }

    private void lists() {
//        ArrayList<Integer> intList0 = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        intList.add(123);
        intList.add(456);
        intList.add(456);
        intList.add(456);

        for (Integer i : intList) {
            System.out.println("intList contents: " + i);
        }

        List<String> strList = new ArrayList<>();
        useList(strList, "ArrayList");

        List<String> linkedList = new LinkedList<>();
        useList(linkedList, "LinkedList");

        List<String> strList2 = List.of("a", "bc", "def"); // immutable list
        // strList2.add("123");
        // useList(strList2, "immutableList");


        Dog max = new Dog("Max", "Whippet", 7, 'S', true);
        Dog dogette = new Dog("Dogette", "Poodle", 6, 'M', false);
        Cat felix = new Cat("Felix", "fatcat", 5, 'L', true);
        Bird polly = new Bird("Polly", "parrot", 9, 'M', false);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(max);
        dogs.add(dogette);
//        dogs.add(felix);

        List<Pet> pets = new ArrayList<>();
        pets.add(max);
        pets.add(dogette);
        pets.add(felix);
        pets.add(polly);
    }

    public void useList(List<String> strList, String info) {

        System.out.println("useList: info=" + info);

        strList.add("xyz");
        strList.add("ijk");
        strList.add("abc");
        strList.add("def");

        System.out.println("strList item 1 is " + strList.get(1));
        strList.remove(1);
        System.out.println("strList size is " + strList.size());
        System.out.println("does strList contain 'abc' " + strList.contains("abc"));

        for (String str : strList) System.out.println("Before Sort: " + str);
        Collections.sort(strList);
        for (String str : strList) System.out.println("After Sort: " + str);
        Collections.reverse(strList);
        for (String str : strList) System.out.println("After reverse: " + str);
    }

    public void arrays() {
        String[] strings = new String[] {"abc", "def", "xyz"};
        String[] strings2 = new String[10];
        int[] ints = new int[]{123, 999, -1};

        System.out.println("item 2 is " + strings[2]);
        strings[2] = "*ijk*";
        strings[0] = null;
//        strings[3] = null;
        System.out.println("item 2 is now " + strings[2]);

        for (String str : strings) {
            System.out.println(str);
        }
        System.out.println("length of strings2 is " + strings2.length);
    }


}
