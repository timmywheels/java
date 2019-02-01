package com.timwheeler;

public class Burger {

    private double price = 3.00;
    private String rollType;
    private String meatType;
    private String topping1;
    private String topping2;
    private String topping3;
    private String topping4;

    public void getPrice() {
        System.out.println("That will be $" + price + " please.");
    }

    public Burger(String rollType, String meatType) {
        this(rollType, meatType, null, null, null, null);
        this.rollType = rollType;
        this.meatType = meatType;
    }

    public Burger(String rollType, String meatType, String topping1) {
        this(rollType, meatType, topping1,null, null, null);
        this.topping1 = topping1;
        price += .50;
    }

    public Burger(String rollType, String meatType, String topping1, String topping2) {
        this(rollType, meatType, topping1, topping2, null, null);
        this.topping2 = topping2;
        price += .50;
    }

    public Burger(String rollType, String meatType, String topping1, String topping2, String topping3) {
        this(rollType, meatType, topping1, topping2, topping3, null);
        this.topping3 = topping3;
        price += .50;
    }

    public Burger(String rollType, String meatType, String topping1, String topping2, String topping3, String topping4) {
        this.rollType = rollType;
        this.meatType = meatType;
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.topping4 = topping4;
        price += .50;
    }



}
