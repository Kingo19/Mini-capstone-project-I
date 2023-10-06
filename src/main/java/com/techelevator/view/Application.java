package com.techelevator.view;

import com.techelevator.CandyStore;
import com.techelevator.CashRegister;
import com.techelevator.Inventory;
import com.techelevator.items.CandyStoreItem;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private CashRegister register = new CashRegister();
   private UserInterface ui = new UserInterface();
   private Inventory inv = new Inventory();

    public static void main(String[] args) {
        Application app = new Application();
        app.run();

    }
    public void run () {
        //set up the main while loop to loop through the menu & menu choices


        while(true){
            int choice = ui.printMainMenu();
            if(choice == 1){
                getInventory();

            }
            else if(choice == 2){
                makeSale();
            }
            else{
                break;
            }

        }
    }

    //method to get Inventory
    private void getInventory(){
        //fetch List from Inventory
        List<CandyStoreItem> inventory = inv.retrieveListOfInventory();
        //send List to UI to print for user
        ui.printInventory(inventory);
    }

    private void makeSale(){

        //MAKE SALE SUBMENU
        while(true){
            int choice = ui.printSaleMenu(register.getBalance());
            if(choice == 1){
                //when we try to put this in its own method it didn't work

                //asking user for amount
                double amountToAdd = ui.askAmountToAdd();
                //tell the cash register to add that amount to its balance
                String registerMessage = register.addToBalance(amountToAdd);
                ui.printMessage(registerMessage);

            }
            else if(choice == 2){
                //method for Select Product
                getInventory();
                ui.selectProduct();

            }
            else{
                //Method for complete sale
            }

        }





    }

//        private void takeMoney(){
//        //asking user for amount
//        double amountToAdd = ui.askAmountToAdd();
//        //tell the cash register to add that amount to its balance
//        register.addToBalance(amountToAdd);
//
//    }

    ;


}
