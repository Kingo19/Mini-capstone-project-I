package com.techelevator;

import com.techelevator.items.CandyStoreItem;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class InventoryTest {
    private Inventory inventory;
    @Before
    public void setUp() {
        // Create an instance of Inventory before each test
        inventory = new Inventory();
    }

    @Test
    public void retrieveListOfInventory_returnsNonEmptyList() {
        List<CandyStoreItem> inventoryList = inventory.retrieveListOfInventory();
        assertNotNull(inventoryList);
        assertTrue(inventoryList.size() > 0);
    }

}
