package com.techelevator;

public class CashRegister {
    private double balance = 0.0;

    public double getBalance() {
        return balance;
    }

    //Add to balance
    public double addToBalance(double amountToAdd){
        balance += amountToAdd;
        return balance;
    }

    //take from balance

}
