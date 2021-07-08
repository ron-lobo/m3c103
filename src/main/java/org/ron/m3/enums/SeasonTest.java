package org.ron.m3.enums;

public class SeasonTest {

    public static void main(String[] args) {
//        processing(Season.AUTUMN);

        for (Season s : Season.values()) {
            processing(s);
        }

        test1();
    }

    private static void processing(Season season) {
//        System.out.printf("yay! it's %s%n", season.toString().toLowerCase());
        System.out.printf("yay! it's %s%n", season.getNameLC());
        if (season == Season.SPRING) {
            System.out.println("Spring has sprung");
        } else if (season == Season.SUMMER) {
            System.out.println("it's gonna be hot");
        }

        switch (season) {
            case SPRING:
                System.out.println("flowers!");
                break;
            case SUMMER:
                System.out.println("heat!");
                break;
            case AUTUMN:
                System.out.println("leaves!");
                break;
            case WINTER:
                System.out.println("snow!");
                break;
        }

        System.out.printf("season=%s: %s%n", season.getNameMC(), season.getDescription());
    }

    private static void test1() {
        System.out.println("test1()");
        System.out.println(Season.isEquals(Season.SPRING, "SPRING"));
        System.out.println(Season.isEquals(Season.SPRING, "spring"));
        System.out.println(Season.isEquals(Season.SPRING, "Spring"));
        System.out.println(Season.isEquals(Season.AUTUMN, "Autumn"));
        System.out.println(Season.isEquals(Season.AUTUMN, "Fall"));
        System.out.println(Season.isEquals(Season.SPRING, "Sprung"));


        String[] strings = new String[]{"SUMMER", "AUTUMN", "FALL", "SprING", "winteR", "123"};
        for (String s : strings) {
            Season season = Season.getSeason(s);
            Season season1 = Season.getSeasonVO(s);
            System.out.printf("s=%s, season=%s, season1=%s%n", s, season, season1);
        }
    }
}
