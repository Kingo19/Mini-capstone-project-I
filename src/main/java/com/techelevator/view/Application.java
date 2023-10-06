package com.techelevator.view;

import com.techelevator.CandyStore;
import com.techelevator.CashRegister;
import com.techelevator.Inventory;
import com.techelevator.ShoppingCart;
import com.techelevator.items.CandyStoreItem;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private CashRegister register = new CashRegister();
   private UserInterface ui = new UserInterface();
   private Inventory inv = new Inventory();
   private ShoppingCart cart = new ShoppingCart();

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
                //asking user for amount
                double amountToAdd = ui.askAmountToAdd();

                //tell the cash register to add that amount to its balance
                String registerMessage = register.addToBalance(amountToAdd);
                ui.printMessage(registerMessage);

            }
            else if(choice == 2){
                //get and print inventory
                getInventory();

                //get information about candy and quantity
                String productIDSelected = ui.selectProduct();
                int selectedQuantity = ui.selectQuantity();

                //validate ID
                try{
                    CandyStoreItem itemToAdd = inv.copyCandy(productIDSelected, selectedQuantity); // could throw null pointer

                    //validate enough inventory
                    if(!inv.validateQuantity(selectedQuantity, productIDSelected)){
                        ui.printMessage("Enter valid quantity");
                    }
                    //validate money
                    else if(!register.validateEnoughMoney(itemToAdd)){
                        ui.printMessage("Not enough balance");
                    }
                    //if validated, remove from inventory, subtract from balance, add to shopping cart
                    else {
                        inv.removeFromInventory(selectedQuantity, productIDSelected);
                        register.removeMoney(itemToAdd);
                        cart.addToCart(itemToAdd);
                    }
                }
                catch (NullPointerException e){
                    ui.printMessage("Invalid Candy");
                }
            }
            else {
                //Method for complete sale
                double subtotal = cart.getSubtotal();
                register.giveChange(subtotal);

            }

        }


    }




}


//TODO Method for validating ints & doubles
//TODO specific error for sold out