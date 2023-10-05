package com.techelevator.items;

/*
    This represents a single candy store item in the system

    This is an abstract class that should be used as a superclass for the more specific items.
 */
public abstract class CandyStoreItem {

    private String name;
    private String ID;
    private String description;
    private double price;
    private int quantity = 100;

    private String isWrapped;

    // CONSTRUCTORS

    public CandyStoreItem(String name, String ID, double price, String isWrapped) {
        this.name = name;
        this.ID = ID;
        this.price = price;

        if(isWrapped.equals("T")){
            this.isWrapped = "Y";
        }
        else if(isWrapped.equals("F")){
            this.isWrapped = "N";
        }
    }


    // GETTERS.

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String isWrapped() {
        return isWrapped;
    }

    // Setter for quantity only.

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
