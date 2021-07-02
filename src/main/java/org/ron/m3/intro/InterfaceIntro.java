package org.ron.m3.intro;

public class InterfaceIntro {

    public interface Vehicle {
        void start();

        void stop();
    }

    public interface Bookable {
        void makeBooking();
    }

    public class Plane implements Vehicle, Bookable {

        @Override
        public void start() {
            System.out.println("Plane takes off");
        }

        @Override
        public void stop() {
            System.out.println("Plane lands");
        }

        public void makeBooking() {
            System.out.println("made Plane booking");
        }
    }


    public static class Bus implements Vehicle {

        @Override
        public void start() {
            System.out.println("Bus starts journey");
        }

        @Override
        public void stop() {
            System.out.println("Bus ends journey");
        }
    }


    public static void main(String[] args) {
        new InterfaceIntro().demo();

        Bus bus1 = new Bus();
//        Plane plane1 = new Plane();
    }

    public void demo() {

        class Taxi implements Vehicle {
            public void start() {
                System.out.println("Taxi starts journey");
            }

            public void stop() {
                System.out.println("Taxi ends journey");
            }
        }

        Bus bus1 = new Bus();
        Plane plane1 = new Plane();
        // Ship ship1 = new Ship();
        // Car car1 = new Car();
        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();
        Bookable rentalBike = new Bookable() {
            public void makeBooking() {
                System.out.println("made rentalBike booking");
            }
        };

        Vehicle[] vehicles = new Vehicle[]{bus1, plane1, taxi1, taxi2};
        Bookable[] bookables = new Bookable[]{plane1, rentalBike};

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
        }
    }
}
