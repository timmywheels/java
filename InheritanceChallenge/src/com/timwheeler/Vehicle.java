package com.timwheeler;

public class Vehicle {

    private int engine;
    protected int gear = 0;
    private int speed = 0;

    public Vehicle(int engine) {
        this.engine = engine;
    }


    public void move(String direction) {
        if (direction.toLowerCase() == "forward") {
            System.out.println("Moving forward");
        }
        if (direction.toLowerCase() == "reverse") {
            System.out.println("Moving in reverse");
        }
    }

    public void steer(String direction){
        if (direction.toLowerCase() == "left") {
            System.out.println("Turning left");
        }
        if (direction.toLowerCase() == "right") {
            System.out.println("Turning right");
        }
    }
}
