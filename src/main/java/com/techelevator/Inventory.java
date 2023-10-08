package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {
    private Map<String, CandyStoreItem> inventoryMap = new TreeMap<>();
    public Inventory () {
        InventoryFileReader fileReader = new InventoryFileReader();
        inventoryMap = fileReader.loadData();

    }

    //METHODS
    public List<CandyStoreItem> retrieveListOfInventory(){
        //creating a blank list for us to populate as we loop through the map
        List<CandyStoreItem> inventoryList = new ArrayList<>();

        //FOR EACH LOOP
        //for (TYPEofTHingLoopingThrough genericNameWePickFOrEachITEM: TheTHingYourLoopingThrough)

        for(Map.Entry<String, CandyStoreItem> currentCandy : inventoryMap.entrySet()){          //special syntax when looping through entries of a map
            CandyStoreItem currentCandyObject = currentCandy.getValue(); //grab the value off the Map (which is the candy object)
            inventoryList.add(currentCandyObject); //adding that candy object to the above array list
        }
        return inventoryList;
    }

    public boolean validateQuantity(int quantity, String itemID){
        CandyStoreItem candy = inventoryMap.get(itemID);

        if(candy.getQuantity() - quantity >= 0 && quantity > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean validateID(String candyID){
        if(inventoryMap.containsKey(candyID)){
            return true;
        }
        return false;
    }

    public void removeFromInventory(int quantity, String itemID){
        CandyStoreItem candy = inventoryMap.get(itemID);
        candy.setQuantity(candy.getQuantity() - quantity);
    }

    public CandyStoreItem copyCandy(String itemID, int quantity){
        CandyStoreItem candyToCopy = inventoryMap.get(itemID); //where null pointer could occur

        CandyStoreItem newCandy;

        if(candyToCopy instanceof ChocolateCandy){
            newCandy = new ChocolateCandy(candyToCopy.getName(), candyToCopy.getID(), candyToCopy.getPrice(), candyToCopy.isWrapped());
        }
        else if (candyToCopy instanceof LicoriceCandy){
            newCandy = new LicoriceCandy(candyToCopy.getName(), candyToCopy.getID(), candyToCopy.getPrice(), candyToCopy.isWrapped());
        }
        else if (candyToCopy instanceof SourCandy){
            newCandy = new SourCandy(candyToCopy.getName(), candyToCopy.getID(), candyToCopy.getPrice(), candyToCopy.isWrapped());
        }
        else{
            newCandy = new HardCandy(candyToCopy.getName(), candyToCopy.getID(), candyToCopy.getPrice(), candyToCopy.isWrapped());
        }

        //assigning new candy appropriate quantity
        newCandy.setQuantity(quantity);

        return newCandy;
    }

    public CandyStoreItem getInventoryItem(String candyID){
        return inventoryMap.get(candyID);
    }


}
