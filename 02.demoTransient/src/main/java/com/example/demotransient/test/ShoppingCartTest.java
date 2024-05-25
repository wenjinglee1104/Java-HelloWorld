package com.example.demotransient.test;

import com.example.demotransient.domain.Item;
import com.example.demotransient.domain.ShoppingCart;

import java.io.*;

/**
 * @className: ShoppingCartTest
 * @author: Scarlet
 * @date: 2024/5/25
 **/
public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart("CreditCard123");
        cart.addItem(new Item("Apple", 0.5, 10));
        cart.addItem(new Item("Banana", 0.2, 20));

        // 序列化购物车到文件
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cart.ser"))) {
            oos.writeObject(cart);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 修改静态变量，模拟商场重启后的变化
        ShoppingCart.mallName = "New Mall";

        // 反序列化购物车从文件
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cart.ser"))) {
            ShoppingCart deserializedCart = (ShoppingCart) ois.readObject();
            System.out.println(deserializedCart);
            System.out.println("Mall Name: " + ShoppingCart.mallName);
            System.out.println("Total Spent: " + ShoppingCart.totalSpent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
