package com.timwheeler;

public class BMW extends Car {

    public BMW(int engine, int wheels) {
        super(engine, wheels);
    }

    public void getSpeed() {
        switch (gear) {
            case 0:
                System.out.println("0mph");
                break;
            case 1:
                System.out.println("20mph");
                break;
            case 2:
                System.out.println("35mph");
                break;
            case 3:
                System.out.println("50mph");
                break;
            case 4:
                System.out.println("75mph");
                break;
            case 5:
                System.out.println("90mph");
                break;
            case 6:
                System.out.println("120mph");
                break;
        }
    }

    public void burnout(){
        System.out.println("Doing a burnout!");
    }

}
