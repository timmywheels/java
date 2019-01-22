package com.timwheeler;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Animal animal = new Animal("Animal", 1, 2, 5, 5);

        Dog dog = new Dog("Rotweiler", 8, 20 , 2, 4, 1, 20, "Short coarse");

        dog.eat();

    }
}
