package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CandyStoreItem;

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



}
