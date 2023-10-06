package com.techelevator;

public class CashRegister {
    private double balance = 0.0;

    public double getBalance() {
        return balance;
    }

    //Add to balance
    public String addToBalance(double amountToAdd){
        if (amountToAdd <= 100 && amountToAdd > 0 && balance + amountToAdd <= 1000) {
            balance += amountToAdd;
            return "Transaction successful";
        } else {
            return "Invalid amount";
        }


    }

    //take from balance

}
