package com.timwheeler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean infoIsCorrect = false;
        boolean loggedIn = false;
        BankAccount account = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, welcome to Block Bank. What is your name?");
        String customerName = scanner.nextLine();

        System.out.println("Nice to meet you, " + customerName + ". Let's get your new account set up.");


        System.out.println("What is your email address?");
        String email = scanner.nextLine();

        System.out.println("Great! And your phone number?");
        String phoneNumber = scanner.nextLine();

        System.out.println("Excellent. How much will your initial deposit be?");
        double initialDeposit = scanner.nextDouble();

        System.out.println("Perfect. I have your information as:\nName: " + customerName + "\nEmail: " + email + "\nPhone: " + phoneNumber + "\nCould you please verify that this information is correct?");
        System.out.println("Enter true or false");
        infoIsCorrect = scanner.nextBoolean();

        if (infoIsCorrect) {
            account = new BankAccount(customerName, email, phoneNumber, initialDeposit);
            account.getAccountInfo();
            loggedIn = true;

        } else {
            System.out.println("Apologies. Let's try this again");
            scanner.close();
        }


        if (loggedIn) {
            account.depositFunds(177);
            account.logout();
        }

    }
}
