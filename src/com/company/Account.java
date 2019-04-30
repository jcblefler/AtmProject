package com.company;

public class Account extends Atm {

    private int accountNum;
    private String userName;
    private double balance;
    private int pin;


    public Account() {
    }

//

    public String displayAccount(){
        return getAccountNum() + " " + getPin() + " " + getUserName() + " " + getBalance();
    }




    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
