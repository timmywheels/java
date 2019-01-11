package com.timwheeler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        scanner.close();

        account.setAccountNumber(accountNumber);

        if (account.loginSuccessful) {

            account.setCustomerName("Tim Wheeler");
            account.setEmail("tim@timwheeler.com");
            account.setPhoneNumber("(774) 245-6079");

            account.depositFunds(100);

            account.getAccountInfo();

//            account.withdrawFunds(233.33);
        }


//        System.out.println();

    }
}
