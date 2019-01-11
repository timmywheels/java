package com.timwheeler;

public class BankAccount {

    private int accountNumber = 0;
    private boolean hasAccountNumber = false;
    private double accountBalance = 100.00;
    private String customerName = null;
    private String email = null;
    private String phoneNumber = null;

    public boolean loginSuccessful = false;


    public void setAccountNumber(int _accountNumber) {
        if (_accountNumber == 5680420 || _accountNumber == 5850257) {
            this.accountNumber = _accountNumber;
            this.hasAccountNumber = true;
            this.loginSuccessful = true;
            System.out.println(this.accountNumber + " successfully logged in!");
        } else {
            System.out.println("Login failed!");
        }

    }

    public void setCustomerName(String _customerName) {
        this.customerName = _customerName;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public void setPhoneNumber(String _phoneNumber) {
        this.phoneNumber = _phoneNumber;
    }

    public int getAccountNumber() {
        System.out.println("Acct #: " + this.accountNumber);
        return this.accountNumber;
    }

    public double getAccountBalance() {
        System.out.println("Balance: " + this.accountBalance);
        return this.accountBalance;
    }

    public String getCustomerName() {
        System.out.println("Customer: " + this.customerName);
        return this.customerName;
    }

    public String getEmail() {
        System.out.println("Email: " + this.email);
        return this.email;
    }

    public String getPhoneNumber() {
        System.out.println("Phone: " + this.phoneNumber);
        return this.phoneNumber;
    }

    public void getAccountInfo() {
        getCustomerName();
        getAccountNumber();
        getAccountBalance();
        getEmail();
        getPhoneNumber();
    }

    public void depositFunds(double _funds) {
        if (this.hasAccountNumber) {
            this.accountBalance += _funds;
            System.out.println("Your account balance is " + this.accountBalance);
        } else {
            System.out.println("Please enter your account number!");
        }
    }

    public void withdrawFunds(double _funds) {
        if (this.hasAccountNumber) {
            if ((this.accountBalance - _funds) < 0) {
                System.out.println("Insufficient funds! \nCurrent Balance: " + this.accountBalance);
            } else {
                this.accountBalance -= _funds;
                System.out.println("Your account balance is " + this.accountBalance);
            }
        } else {
            System.out.println("Please enter your account number!");
        }
    }


}
