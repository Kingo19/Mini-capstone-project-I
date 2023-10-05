package com.techelevator.view;

import com.techelevator.CandyStore;
import com.techelevator.items.CandyStoreItem;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner = new Scanner(System.in);
    public int printMainMenu() {
        System.out.println("(1) Show Inventory");
        System.out.println("(2) Make Sale");
        System.out.println("(3) Quit");

        int choice = myScanner.nextInt();
        myScanner.nextLine();

        return choice;
    }


    //print f syntax
    // %starts a 'format statement'
    // - forces left align
    // 10 gives 10 character spaces of width
    // s because it's a string
    public void printInventory(List<CandyStoreItem> inventory){
        //loop through List print out each item
        System.out.printf("%-5s  %-15s  %-10s  %-10s  %-10s %n", "ID", "Name", "Wrapper", "Quantity", "Price");


        for(CandyStoreItem candy : inventory){
            if(candy.getQuantity() == 0){
                System.out.printf("%-5s  %-15s  %-10s  %-10s  %-10s %n", candy.getID(), candy.getName(), candy.isWrapped(), "SOLD OUT", "$" + candy.getPrice());
            }
            else {
                System.out.printf("%-5s  %-15s  %-10s  %-10s  %-10s %n", candy.getID(), candy.getName(), candy.isWrapped(), candy.getQuantity(), "$" + candy.getPrice());
            }
        }

    }



}
