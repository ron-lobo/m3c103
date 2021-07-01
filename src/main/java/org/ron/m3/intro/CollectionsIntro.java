package org.ron.m3.intro;

import org.ron.m3.my1stOOP.pets.Bird;
import org.ron.m3.my1stOOP.pets.Cat;
import org.ron.m3.my1stOOP.pets.Dog;
import org.ron.m3.my1stOOP.pets.Pet;

import java.util.*;

public class CollectionsIntro {

    public static final String EDWARD_CULLEN = "Edward Cullen";
    public static final String BELLA_SWAN = "Bella Swan";
    public static final String JACOB_BLACK = "Jacob Black";
    public static final String ARO_VENTURI = "Aro Venturi";

    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
        ci.arrays();
        ci.lists();
        ci.sets();
        ci.maps();
    }

    private void maps() {
        System.out.println("\nMaps");
        Map<String, Integer> map0 = new HashMap<>();

        Map<String, String> id2phoneMap = new HashMap<>();
        id2phoneMap.put(EDWARD_CULLEN, "123 456");
        id2phoneMap.put(BELLA_SWAN, "123 555");
        id2phoneMap.put(JACOB_BLACK, "123 444");
        id2phoneMap.put(ARO_VENTURI, "123 333");
        // id2phoneMap.put(123, Boolean.TRUE);  wrong types - not allowed

        String bellasNumber = id2phoneMap.get("Bella");
        System.out.println("Bella's phone number (NOT in map): " + bellasNumber);
        System.out.println("Bella Swan's phone number        : " + id2phoneMap.get(BELLA_SWAN));
        System.out.println("value of key which isn't in map  : " + id2phoneMap.get(123)); // beware

        id2phoneMap.put(BELLA_SWAN, "123 554");
        System.out.println("Bella Swan's phone number        : " + id2phoneMap.get(BELLA_SWAN));

        Set<String> bellasPhoneSet = new HashSet<>();
        bellasPhoneSet.add("123 551");
        bellasPhoneSet.add("123 552");
        bellasPhoneSet.add("123 553");
        bellasPhoneSet.add("123 554");

        Map<String, Set<String>> id2phonesetMap = new HashMap<>();
        id2phonesetMap.put(EDWARD_CULLEN, Set.of("123 456", "321 456"));
        id2phonesetMap.put(BELLA_SWAN, bellasPhoneSet);

        Set<String> bellasNumbers = id2phonesetMap.get(BELLA_SWAN);
        System.out.println("Bella Swan's phone number set    : " + bellasNumbers);
        bellasNumbers.add("321 556");

        for (String id : id2phoneMap.keySet()) {
            System.out.println("id=" + id + ", number=" + id2phoneMap.get(id));
            // id2phoneMap.remove(id);  // causes ConcurrentModificationException
        }
        for (String number : id2phoneMap.values()) {
            System.out.println("number=" + number);
        }
        for (Map.Entry<String, String> entry : id2phoneMap.entrySet()) {
            System.out.println("id=" + entry.getKey() + ", number=" + entry.getValue());
        }

        System.out.println("id2phoneMap size = " + id2phoneMap.size());
        for (Iterator<String> iter = id2phoneMap.keySet().iterator(); iter.hasNext();) {
            String id = iter.next();
            System.out.println("id=" + id + ", number=" + id2phoneMap.get(id));
            iter.remove();
        }
        System.out.println("id2phoneMap size = " + id2phoneMap.size());
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

        System.out.println("max is in pets: " + pets.contains(max));
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
