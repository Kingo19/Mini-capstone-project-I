package com.techelevator.view;

import com.techelevator.CandyStore;
import com.techelevator.CashRegister;
import com.techelevator.items.CandyStoreItem;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner = new Scanner(System.in);
    public int printMainMenu() {
        System.out.println("");
        System.out.println("(1) Show Inventory");
        System.out.println("(2) Make Sale");
        System.out.println("(3) Quit");

        try {
            int choice = Integer.parseInt(myScanner.nextLine());


            if (choice != 1 && choice !=2 && choice !=3) {
                return 4;
            }  return choice;
        } catch (Exception e) {
            return 4;
        }

    }

    public int printSaleMenu(double currentBalance){
        //is it bad to instantiate a Cash Register here?

        System.out.println("");
        System.out.println("(1) Take Money");
        System.out.println("(2) Select Products");
        System.out.println("(3) Complete Sale");
        System.out.printf("%-20s %.2f %n", "Current Customer Balance: $", currentBalance);


        try {
            int choice = Integer.parseInt(myScanner.nextLine());


            if (choice != 1 && choice !=2 && choice !=3) {
                return 4;
            }  return choice;
        } catch (Exception e) {
            return 4;
        }

    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public double askAmountToAdd(){
        System.out.println("Enter amount to add: ");
        try {
            return Double.parseDouble(myScanner.nextLine());
        } catch (Exception e) {
            return 0.00;
        }

    }

    public String selectProduct() {
        System.out.println("Select product ID: ");
        return myScanner.nextLine();
    }
    public int selectQuantity(){
        System.out.println("Select Quantity: ");
        try {
            return Integer.parseInt(myScanner.nextLine());
        } catch (Exception e) {
            return 0;
        }


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
                System.out.printf("%-5s  %-15s  %-10s  %-10s %1s %.2f %n", candy.getID(), candy.getName(), candy.isWrapped(), "SOLD OUT", "$" + candy.getPrice());
            }
            else {
                System.out.printf("%-5s  %-15s  %-10s  %-10s %1s %.2f %n", candy.getID(), candy.getName(), candy.isWrapped(), candy.getQuantity(), "$", candy.getPrice());
            }
        }


    }
    public void printReceipt(List<CandyStoreItem> itemsBought, double subtotal, double change, String changeStatement) {

        System.out.println("");
        for (CandyStoreItem candy : itemsBought){
            System.out.printf("%-5s  %-15s  %-30s  %-10s  %1s %.2f  %n", candy.getQuantity(), candy.getName(), candy.getDescription(),  "$" + candy.getPrice(), "$" , candy.getQuantity() * candy.getPrice());
        }

        System.out.println("");
        System.out.printf("%-10s %1s %.2f %n", "Total:" , "$" , subtotal);
        System.out.printf("%-10s %1s %.2f %n", "Change:" , "$" , change);
        System.out.println(changeStatement);

    }

}

