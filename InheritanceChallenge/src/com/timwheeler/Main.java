package com.timwheeler;

public class Main {

    public static void main(String[] args) {
	// write your code here

        var M3 = new BMW(1, 4);

        M3.upShift();
        M3.getSpeed();

        M3.upShift();
        M3.getSpeed();

        M3.upShift();
        M3.getSpeed();

        M3.upShift();
        M3.getSpeed();
        M3.steer("left");

        M3.upShift();
        M3.getSpeed();
        M3.steer("left");

        M3.upShift();
        M3.getSpeed();
        M3.steer("right");

        M3.downShift();
        M3.getSpeed();
        M3.move("forward");

        M3.downShift();
        M3.getSpeed();

        M3.downShift();
        M3.getSpeed();

        M3.downShift();
        M3.getSpeed();
        M3.burnout();

        M3.downShift();
        M3.downShift();

        M3.move("reverse");

    }
}
