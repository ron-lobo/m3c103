package org.ron.m3.changes;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class containing static utility methods
 */
public class Utils {

    private static final Logger logger = Logger.getLogger(Utils.class.getName());
    private static final char SPACE = ' ';

    private Utils() {
    }

    public static void main(String[] args) {
        final int items = 10;
        final int minValue = 200;
        final int maxValue = 300;
        print("getRandomList() [loop]   ", getRandomList(items, minValue, maxValue));
        print("getRandomMap()  [loop]   ", getRandomMap(items, maxValue));
    }

    // ----------------------------------------

    // create and populate a list with some random values
    public static List<Integer> getRandomList(int maxItems, int minValue, int maxValue) {
        final int numItems = getRandomInt(0, maxItems);
        logger.fine("creating a random list with " + numItems + " items");
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < numItems; i++) {
            myList.add(getRandomInt(minValue, maxValue));
        }
        return myList;
    }

    // create and populate a map with some random values
    public static Map<Integer, Integer> getRandomMap(int maxItems, int maxValue) {
        final int numItems = getRandomInt(0, maxItems);
        logger.fine("creating a random map with " + numItems + " items");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numItems; i++) {
            map.put(getRandomInt(0, maxValue), getRandomInt(0, maxValue));
        }
        return map;
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
        // return (int) (Math.random() * (max - min) + 0.5) + min;
    }


    // ----------------------------------------
    // Printing Section
    // TODO: replace System.out.println() and System.err.println() with logging

    public static String print(Object o) {
        return print(true, o);
    }

    public static String print(boolean isOk, Object o) {
        String s = o == null ? "" : o.toString();
        PrintStream printStream = isOk ? System.out : System.err;
        printStream.println(s);
//		if (isOk) { System.out.println(s); } else { System.err.println(s); }
        return s;
    }

    public static void printStream(String text, Stream<?> stream) {
        print(text, "=", stream.collect(Collectors.toList()));
    }

    public static String print(Object... objects) {
        return printObjects(true, SPACE, objects);
    }

    public static String printerr(Object... objects) {
        return printObjects(false, SPACE, objects);
    }

    public static String printObjects(boolean isOk, char delimiter, Object... objects) {
        StringBuilder sb = new StringBuilder();
        for (Object o : objects) {
            if (o != null) {
                if (sb.length() > 0) {
                    sb.append(delimiter);
                }
                sb.append(o.toString());
            }
        }
        return print(isOk, sb);
    }

    public static void newMethod(String method) {
        String underline = method.replaceAll(".", "-");
        printObjects(true, '\n', "", method, underline);
    }
}
