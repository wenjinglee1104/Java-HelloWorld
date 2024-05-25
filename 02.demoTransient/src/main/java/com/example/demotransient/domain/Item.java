package com.example.demotransient.domain;

import lombok.Data;
import java.io.*;

/**
 * @className: Item
 * @author: Scarlet
 * @date: 2024/5/25
 **/
@Data
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', price=" + price + ", quantity=" + quantity + '}';
    }
}
