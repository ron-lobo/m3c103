package org.ron.m3.intro;

import org.ron.m3.my1stOOP.pets.Bird;
import org.ron.m3.my1stOOP.pets.Cat;
import org.ron.m3.my1stOOP.pets.Dog;
import org.ron.m3.my1stOOP.pets.Pet;

import java.util.*;

public class CollectionsIntro {

    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
        ci.arrays();
        ci.lists();
        ci.sets();
    }

    private void sets() {
        System.out.println("\nSets");

        Set<String> stringSet = new HashSet<>();
        stringSet.add("abc");
        stringSet.add("123");
        stringSet.add("hi there");
        stringSet.add("xyz");

        System.out.println("number of elements in stringSet: " + stringSet.size());
        stringSet.add("xyz");
        stringSet.add("abc");
        stringSet.add("123");
        System.out.println("number of elements in stringSet: " + stringSet.size());
        stringSet.add(null);
        stringSet.add("456");
        System.out.println("number of elements in stringSet: " + stringSet.size());

        for (String s : stringSet) {
            System.out.println("stringSet contains: " + s);
        }

        List<Integer> intList = createIntList();
        Set<Integer> intSet = new HashSet<>(intList);

        System.out.println("intList size: " + intList.size());
        System.out.println("intSet size: " + intSet.size());
        for (Integer i : intSet) {
            System.out.println("intSet contains: " + i);
            // intSet.remove(i);
        }

        System.out.println("\nstringSet size: " + stringSet.size());
        for (Iterator<String> iter = stringSet.iterator(); iter.hasNext();) {
            String element = iter.next();
            System.out.println("(Iterator) stringSet contains: " + element);
            if (element == null) {
                iter.remove();
            }
        }
        System.out.println("stringSet size: " + stringSet.size());
    }

    private void lists() {
        System.out.println("\nLists");

        // ArrayList<Integer> intList0 = new ArrayList<>();  // don't declare like this

        List<Integer> intList = createIntList();
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
        pets.add(0, polly);
    }

    private List<Integer> createIntList() {
        List<Integer> intList = new ArrayList<>();
        intList.add(123);
        intList.add(456);
        intList.add(456);
        intList.add(456);
        intList.add(3, null);
        return intList;
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
