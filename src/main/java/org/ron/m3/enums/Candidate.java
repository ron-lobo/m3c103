package org.ron.m3.enums;

import java.util.List;

public class Candidate {

    int id;
    //    String name;
//    List qualifications;
//    List skills;
//    int age;
//    String nationality;
//    // interests;
    Gender gender;

    public Candidate(int id, Gender gender) {
        this.id = id;
        this.gender = gender;
    }

    public Gender isMale() {
        return gender;
    }

    public static void main(String[] args) {

        Candidate c1 = new Candidate(1, Gender.MALE);
        Candidate c2 = new Candidate(2, Gender.FEMALE);
        Candidate c3 = new Candidate(3, Gender.UNKNOWN);
        Candidate c4 = new Candidate(4, Gender.NEITHER);
        Candidate c5 = new Candidate(5, Gender.BOTH);

        List<Candidate> candidates = List.of(c1, c2, c3, c4, c5);
        processing(candidates);
    }

    private static void processing(List<Candidate> candidates) {
        for (Candidate candidate : candidates) {
            System.out.printf("candidate %s: %s%n", candidate.id, candidate.gender);
        }
    }
}
