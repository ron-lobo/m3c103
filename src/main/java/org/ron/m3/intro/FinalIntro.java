package org.ron.m3.intro;

import org.ron.m3.my1stOOP.pets.Pet;

import java.util.Collections;
import java.util.List;

public class FinalIntro {

    private class Employee {
        private final int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void m1() {
            // id = 5;
            name = name + " PhD";
            name = null;
        }
    }

    private class Dept {
        private Employee deptHead;
        private final List<Employee> members;
        private final List<Pet> pets;

        public Dept(Employee deptHead, List<Employee> members, List<Pet> pets) {
            this.deptHead = deptHead;
            this.members = members;
            this.pets = Collections.unmodifiableList(pets);
            // this.pets.clear(); // beware
        }

        public void m1(Employee newDeptHead) {
//            members = null;
//            members = new ArrayList<>();
            members.remove(deptHead);
            members.add(newDeptHead);
            deptHead = newDeptHead;
        }
    }

    public static void main(String[] args) {
        InterfaceIntro interfaceIntro = new InterfaceIntro();
        InterfaceIntro.Plane plane = interfaceIntro.new Plane();

        InterfaceIntro.Bus bus = new InterfaceIntro.Bus();
    }
}
