package com.timwheeler;

import java.util.Random;

public class BankAccount {

    private int accountNumber = 0;
    private int accountPin = 0;
    private boolean hasAccountNumber = false;
    private double accountBalance = 0;
    private double initialDeposit = 0;
    private String customerName = null;
    private String email = null;
    private String phoneNumber = null;

    public boolean loginSuccessful = false;

    public BankAccount(String _customerName, String _email, String _phoneNumber, double _initialDeposit) {
        this.accountNumber = this.generateAccountNumber();
        this.initialDeposit = _initialDeposit;
        this.accountBalance += _initialDeposit;
        this.customerName = _customerName;
        this.email = _email;
        this.phoneNumber = _phoneNumber;

        hasAccountNumber = true;
        loginSuccessful = true;
    }

    public int generateAccountNumber(){
        Random rand = new Random();
        accountNumber = rand.nextInt(999999999);
        return accountNumber;
    }

    public int generateAccountPin(){
        Random rand = new Random();
        accountPin = rand.nextInt(9999);
        return accountPin;
    }

    public void logout() {
        System.out.println("You've been logged out!");
    }

    public void login(int _accountNumber, int _accountPin){
        if (_accountNumber == this.accountNumber && _accountPin == this.accountPin) {
            System.out.println("Login successful");
            this.getAccountInfo();
        }
    }

    public void setAccountNumber(int _accountNumber) {
        if (_accountNumber == 5680420 || _accountNumber == 5850257) {
            accountNumber = _accountNumber;
            hasAccountNumber = true;
            loginSuccessful = true;
            System.out.println(accountNumber + " successfully logged in!");
        } else {
            System.out.println("Login failed!");
        }
    }

    public void setCustomerName(String _customerName) {
        customerName = _customerName;
    }

    public void setEmail(String _email) {
        email = _email;
    }

    public void setPhoneNumber(String _phoneNumber) {
        phoneNumber = _phoneNumber;
    }

    public int getAccountNumber() {
        System.out.println("Acct #: " + accountNumber);
        return accountNumber;
    }

    public double getAccountBalance() {
        System.out.println("Balance: " + accountBalance);
        return accountBalance;
    }

    public String getCustomerName() {
        System.out.println("Customer: " + customerName);
        return customerName;
    }

    public String getEmail() {
        System.out.println("Email: " + email);
        return email;
    }

    public String getPhoneNumber() {
        System.out.println("Phone: " + phoneNumber);
        return phoneNumber;
    }

    public void getAccountInfo() {
        getAccountNumber();
        getCustomerName();
        getAccountBalance();
        getEmail();
        getPhoneNumber();
    }

    public void depositFunds(double _funds) {
        if (hasAccountNumber) {
            accountBalance += _funds;
            System.out.println("Your account balance is " + accountBalance);
        } else {
            System.out.println("Please enter your account number!");
        }
    }

    public void withdrawFunds(double _funds) {
        if (hasAccountNumber) {
            if ((accountBalance - _funds) < 0) {
                System.out.println("Insufficient funds! \nCurrent Balance: " + accountBalance);
            } else {
                accountBalance -= _funds;
                System.out.println("Your account balance is " + accountBalance);
            }
        } else {
            System.out.println("Please enter your account number!");
        }
    }


}
