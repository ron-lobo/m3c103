package org.ron.m3.enums;

import java.time.LocalDate;
import java.time.Month;

public enum Season {

    SPRING("flower season", Month.MARCH),
    SUMMER("the hot season", Month.JUNE),
    AUTUMN("falling leafs", Month.SEPTEMBER, "Fall"),
    WINTER("getting colder", Month.DECEMBER);

    private final String description;
    private final Month startMonth;
    private final String altName;

    Season(String description, Month startMonth) {
        this(description, startMonth, null);
    }

    Season(String description, Month startMonth, String altName) {
        this.description = description;
        this.startMonth = startMonth;
        this.altName = altName;
    }

    public String getDescription() {
        return description;
    }

    public String getNameLC() {
        return name().toLowerCase();
    }

    public String getNameMC() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public LocalDate getStartDate(int year) {
        return LocalDate.of(year, startMonth, 21);
    }

    public static boolean isEquals(Season season, String str) {
        return (season.name().equalsIgnoreCase(str) ||
                (season.altName != null && season.altName.equalsIgnoreCase(str)));
    }

    public static Season getSeason(String str) {
        for (Season season : Season.values()) {
            if (isEquals(season, str)) {
                return season;
            }
        }
        return null;
    }

    public static Season getSeasonVO(String str) {
        try {
            return Season.valueOf(str);
        } catch (Exception e) {
            return null;
        }
    }
}
