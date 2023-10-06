package com.techelevator;

import com.techelevator.items.CandyStoreItem;

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

    public boolean validateEnoughMoney(CandyStoreItem candyToValidate){
        if(candyToValidate.getQuantity()*candyToValidate.getPrice() <= balance){
            return true;
        }
        else{
            return false;
        }
    }

    //take from balance
    public void removeMoney(CandyStoreItem candy){
        balance -= (candy.getPrice() * candy.getQuantity());
    }

    public void giveChange(double subtotal){
        double change = balance - subtotal;
        double remaining = subtotal;

        double[] denominations = new double[]{20.0, 10.0 , 5.0 , 1.0 , 0.25 , 0.10 , 0.5};
        int[] amount = new int[7];

        for(int i = 0; i < 7 ; i++){
            amount[i] = (int)(remaining / denominations[i]);
            remaining = remaining - amount[i]*denominations[i];
        }

        String changeStatement

    }


}
