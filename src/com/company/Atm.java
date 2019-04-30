package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
    Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df2 = new DecimalFormat("#.00");

    private boolean account = false;
    private ArrayList<Account> users = new ArrayList<>();


    private int accountLocation;
    private int loginAttempts = 0;
    private boolean loginSuccessful;




    public Atm() {
    }

    public boolean accountCheck(){
        System.out.println("Do you have an account. (y/n)");
        String answer = scanner.next();
        if(answer.equalsIgnoreCase("y")){
            account = true;
        } else{
            account = false;
        }

        if(account == true){
            login();
        }else{
            createAccount();
        }
        return true;
    }

    public void login(){



        loop:
        while(loginAttempts < 3) {
             System.out.println("Enter your account number: ");
            int userInputAccount = scanner.nextInt();

            System.out.println("Enter your account pin: ");
            int userInputPin = scanner.nextInt();


            for (int i = 0; i < users.size(); i++) {
                if (userInputAccount == users.get(i).getAccountNum() && userInputPin == users.get(i).getPin()) {
                    accountLocation = i;
                    loginSuccessful = true;
                    System.out.println("Welcome, " + users.get(accountLocation).getUserName() + ".");
                    break loop;
                }
            }
            loginAttempts++;
            loginSuccessful = false;
        }
        if (loginAttempts >= 3){
            System.out.println("Your account has been locked out.");
        }
        if (loginSuccessful == true){
            transaction();
        }

     }


     public boolean transaction(){

         System.out.println("Would you like to make a withdraw, deposit, or check balance.");
         String userInput = scanner.next();

         if (userInput.equalsIgnoreCase("withdraw")){
             System.out.println("How much are you withdrawing.");
             double withdrawAmount = scanner.nextDouble();
             System.out.println("Your balance is now $" + df2.format(users.get(accountLocation).getBalance() - withdrawAmount));
             users.get(accountLocation).setBalance(users.get(accountLocation).getBalance() - withdrawAmount);
         } else if (userInput.equalsIgnoreCase("deposit")){
             System.out.println("How much are you depositing.");
             double depositAmount = scanner.nextDouble();
             System.out.println("Your balance is now $" + df2.format(users.get(accountLocation).getBalance() + depositAmount));
             users.get(accountLocation).setBalance(users.get(accountLocation).getBalance() + depositAmount);
         } else if (userInput.equalsIgnoreCase("check")){
             System.out.println("Your balance is: $" + df2.format(users.get(accountLocation).getBalance()));
         }
         System.out.println("Would you like to make another transaction. (y/n)");
         String userAnswer = scanner.next();
         if (userAnswer.equalsIgnoreCase("y")){
             transaction();
         } else{
             System.out.println("Have a nice day, " + users.get(accountLocation).getUserName() + ".\n\n");
         }
         return accountCheck();
     }


    public boolean createAccount(){

        Account user = new Account();
        System.out.println("Enter an account Number: ");
        user.setAccountNum(scanner.nextInt());
        System.out.println("Enter a pin number: ");
        user.setPin(scanner.nextInt());
        System.out.println("Enter your user name: ");
        user.setUserName(scanner.next());
        System.out.println("Enter your balance: ");
        user.setBalance(scanner.nextDouble());


        users.add(user);

        return accountCheck();
    }


    public boolean isAccount() {
        return account;
    }

    public void setAccount(boolean account) {
        this.account = account;
    }

    public ArrayList<Account> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Account> users) {
        this.users = users;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }
}
