package com.techelevator.view;

import com.techelevator.CandyStore;
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

        int choice = ui.printMainMenu(); //we'll write this method later
        while(true){
            if(choice == 1){
                getInventory();
                break;
            }
            else if(choice == 2){
                //method for Make Sale
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


}
