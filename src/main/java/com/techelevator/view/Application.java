package com.techelevator.view;

import com.techelevator.CandyStore;
import com.techelevator.CashRegister;
import com.techelevator.Inventory;
import com.techelevator.items.CandyStoreItem;

import java.util.ArrayList;
import java.util.List;

public class Application {

    UserInterface ui = new UserInterface();
    Inventory inv = new Inventory();

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
        //instantiate one cash register for this entire makeSale() transaction
        CashRegister register = new CashRegister();

        //MAKE SALE SUBMENU
        while(true){
            int choice = ui.printSaleMenu(register.getBalance());
            if(choice == 1){
                //when we try to put this in its own method it didn't work

                //asking user for amount
                double amountToAdd = ui.askAmountToAdd();
                //tell the cash register to add that amount to its balance
                register.addToBalance(amountToAdd);
                /*TODO why does it not work when we try to put the above in its own method?
                TODO put up barriers so the user can't add more than $100 at a time
                TODO put up barriers so the balance can't equal more than $1000
                TODO put up barriers so the user must input more than $0


                 */

            }
            else if(choice == 2){
                //method for Select Product
            }
            else{
                //Method for complete sale
            }

        }





    }

//    private void takeMoney(){
//        //asking user for amount
//        double amountToAdd = ui.askAmountToAdd();
//        //tell the cash register to add that amount to its balance
//        register.addToBalance(amountToAdd);
//
//    }

    ;


}
