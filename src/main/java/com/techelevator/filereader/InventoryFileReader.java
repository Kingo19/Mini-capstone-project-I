package com.techelevator.filereader;

import com.techelevator.CandyStore;
import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {

    private File inventoryFile = new File("inventory.csv");

    //    private String inventoryFileName; DO WE NEED THIS ??
    private Scanner inventoryInputScanner;

    public InventoryFileReader() {
        try {
            inventoryInputScanner = new Scanner(inventoryFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    //        this.inventoryFileName = inventoryFileName;

    }

    // Takes info from file and loads it to map.
    // Call this method in inventory constructor.

    public Map<String, CandyStoreItem> loadData() {
        Map<String, CandyStoreItem> candyItems = new TreeMap<>();
        // Instantiate blank map.
        while (inventoryInputScanner.hasNextLine()) {
            // Save current line in a string.
            String currentCandy = inventoryInputScanner.nextLine();
            // Split it to different items in an array.
            String[] currentCandyArray = currentCandy.split("|"); // Do we need to do something with this?
            if (currentCandyArray[0].equals("CH")) {
                CandyStoreItem newCandy = new ChocolateCandy(currentCandyArray[2], currentCandyArray[1], Double.parseDouble(currentCandyArray[3]), currentCandyArray[4]);
                candyItems.put(currentCandyArray[1], newCandy);
            } else if (currentCandyArray[0].equals("SR")) {
                CandyStoreItem newCandy = new SourCandy(currentCandyArray[2], currentCandyArray[1], Double.parseDouble(currentCandyArray[3]), currentCandyArray[4]);
                candyItems.put(currentCandyArray[1], newCandy);
            } else if (currentCandyArray[0].equals("HC")) {
                CandyStoreItem newCandy = new HardCandy(currentCandyArray[2], currentCandyArray[1], Double.parseDouble(currentCandyArray[3]), currentCandyArray[4]);
                candyItems.put(currentCandyArray[1], newCandy);
            } else {
                CandyStoreItem newCandy = new LicoriceCandy(currentCandyArray[2], currentCandyArray[1], Double.parseDouble(currentCandyArray[3]), currentCandyArray[4]);
                candyItems.put(currentCandyArray[1], newCandy);
            }

        }
        return candyItems;
    }
}
