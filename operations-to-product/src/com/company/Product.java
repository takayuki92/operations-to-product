package com.company;

import java.io.Serializable;

/**
 * @Product class to contain info and behaviors of a product
 */
public class Product implements Serializable {
    String id;
    String title;
    int quantity;
    double price;
    //Default constructor
    public Product() {};

    /**
     * Constructor method to initialize a product
     * @param id
     * @param title
     * @param quantity
     * @param price
     */
    public Product(String id, String title, int quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
    public String toString() {
        return id + " | " + title + " | " + quantity + " | " + price;
    }

}
