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


    public void printInventory(List<CandyStoreItem> inventory){
        //loop through List print out each item
        System.out.printf("| %-10s | %-10s | %-10s | %-8s | %4s |%n", "ID", "Name", "Wrapper", "Quantity", "Price");

    }



}
