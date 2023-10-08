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


    //TODO write tests for removefrominventory and copy candy

    @Test
    public void remove_from_inventory_changes_quantity(){
        //Arrange

        //Act
        inventory.removeFromInventory(25, "S4");
        CandyStoreItem candy = inventory.getInventoryItem("S4");
        int newQuantity = candy.getQuantity();

        //Assert
        Assert.assertEquals(75, newQuantity);
    }

    @Test
    public void copy_candy_makes_correct_candy_type(){
        //Arrange
        //Act
        CandyStoreItem newCandy = inventory.copyCandy("H1" , 10);
        //Assert
        Assert.assertEquals("Jolly Cowboy", newCandy.getName());
    }
    @Test
    public void copy_candy_sets_correct_quantity(){
        //Arrange

        //Act
        CandyStoreItem newCandy = inventory.copyCandy("H1" , 10);

        //Assert
        Assert.assertEquals(10, newCandy.getQuantity());
    }

}
