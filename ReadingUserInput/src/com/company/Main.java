package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // built in class for reading user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        scanner.close();

        System.out.println("Hello, " + name);
    }
}
