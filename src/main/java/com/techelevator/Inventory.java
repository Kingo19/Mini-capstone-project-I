package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CandyStoreItem;

import java.util.Map;
import java.util.TreeMap;

public class Inventory {
    private Map<String, CandyStoreItem> inventoryMap = new TreeMap<>();
    public Inventory () {
        InventoryFileReader fileReader = new InventoryFileReader();
        inventoryMap = fileReader.loadData();
    }


}
