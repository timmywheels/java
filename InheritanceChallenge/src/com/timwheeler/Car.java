package com.timwheeler;

public class Car extends Vehicle {

    private int wheels;

    public Car(int engine, int wheels) {
        super(engine);
        this.wheels = wheels;
    }

    public void upShift() {
        if (gear >= 0 && gear <= 6) {
            gear++;
        } else {
            System.out.println("Can't upshift! You only have 6 gears...");
        }
        System.out.println("You're in gear " + gear + ".");
    }

    public void downShift() {
        if (gear <= 6 && gear > 0) {
            gear--;
        } if (gear == 0) {
            System.out.println("You're in neutral");
        }else {
            System.out.println("Can't downshift");
        }
        System.out.println("You're in gear " + gear + ".");
    }



}
