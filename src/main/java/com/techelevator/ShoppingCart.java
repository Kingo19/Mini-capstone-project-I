package com.techelevator;

import com.techelevator.items.CandyStoreItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {

    private List<CandyStoreItem> cartItems = new ArrayList<>();

    public void addToCart(CandyStoreItem candyToAdd){
        cartItems.add(candyToAdd);
    }

    public double getSubtotal(){
        double subtotal = 0;

        for(CandyStoreItem currentCandy : cartItems){
            //finding the total cost per item
            double itemTotal = currentCandy.getPrice() * currentCandy.getQuantity();
            //adding that to the subtotal
            subtotal += itemTotal;
        }

        return subtotal;

    }

}
