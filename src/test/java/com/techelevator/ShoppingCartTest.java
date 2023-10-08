package com.techelevator;

import com.techelevator.ShoppingCart;
import com.techelevator.items.CandyStoreItem;
import com.techelevator.items.ChocolateCandy;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    public void addToCart_AddsItemToCart() {
        CandyStoreItem candy = new ChocolateCandy("Chocolate Bar", "CHOCO", 1.50, "Y");
        cart.addToCart(candy);

        List<CandyStoreItem> cartItems = cart.getCartItems();

        assertEquals(1, cartItems.size());
        assertTrue(cartItems.contains(candy));
    }

    @Test
    public void getSubtotal_ReturnsCorrectSubtotal() {
        CandyStoreItem candy1 = new ChocolateCandy("Candy A", "CANDY_A", 1.25, "Y");
        CandyStoreItem candy2 = new ChocolateCandy("Candy B", "CANDY_B", 2.00, "N");

        cart.addToCart(candy1);
        cart.addToCart(candy2);


        double expectedSubtotal = (1.25 * 100) + (2 * 100);
        double actualSubtotal = cart.getSubtotal();

        assertEquals(expectedSubtotal, actualSubtotal, .001); // Using delta for double comparison
    }

    @Test
    public void clearShoppingCart() {

        CandyStoreItem candy1 = new ChocolateCandy("Candy A", "CANDY_A", 1.25, "Y");
        CandyStoreItem candy2 = new ChocolateCandy("Candy B", "CANDY_B", 2.00, "N");

        cart.addToCart(candy1);
        cart.addToCart(candy2);

        cart.clearCartItems();

        Assert.assertEquals(0, cart.getCartItems().size());
    }

}