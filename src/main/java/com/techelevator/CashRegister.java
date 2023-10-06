package com.techelevator;

import com.techelevator.filereader.LogFileWriter;
import com.techelevator.items.CandyStoreItem;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {

    private double balance = 0.0;
    //instantiated log file in register because it has access to all the necessary information
    private LogFileWriter fileWriter = new LogFileWriter();

    public double getBalance() {
        return balance;
    }

    //Add to balance
    public String addToBalance(double amountToAdd) {
        double oldBalance = balance;
        if (amountToAdd <= 100 && amountToAdd > 0 && balance + amountToAdd <= 1000) {
            balance += amountToAdd;
            fileWriter.writeLogMoneyAdded(oldBalance, balance);
            return "Transaction successful";
        } else {
            return "Invalid amount";
        }

        //call the log printer


    }

    public boolean validateEnoughMoney(CandyStoreItem candyToValidate) {
        if (candyToValidate.getQuantity() * candyToValidate.getPrice() <= balance) {
            return true;
        } else {
            return false;
        }
    }

    //take from balance
    public void removeMoney(CandyStoreItem candy) {
        double amountToDeduct = candy.getPrice() * candy.getQuantity();
        balance -= amountToDeduct;

        //call the log printer
        fileWriter.writeLogCandySelection(candy, balance);

    }


    public String changeStatement() {
        double remaining = balance;
        double[] denominations = new double[]{20.0, 10.0 , 5.0 , 1.0 , 0.25 , 0.10 , 0.5};
        int[] amount = new int[7];

        String[] names = new String[]{"Twenties", "Tens", "Fives" , "Ones", "Quarters", "Dimes","Nickles"};
        String currencyStatements = "";

        for(int i = 0; i < 7 ; i++) {
            amount[i] = (int) (remaining / denominations[i]);
            remaining = remaining - amount[i] * denominations[i];
            if (amount[i] !=0) {
               currencyStatements += ("(" + amount[i] + ") " + names[i] + " ");
            }
        }
       return currencyStatements;
    }

    public void clearRegister(){
        balance = 0;
    }

    public void printChange(){
        fileWriter.writeLogChangeGiven(balance);
    }


}
