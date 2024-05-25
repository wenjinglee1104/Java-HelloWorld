package com.example.demotransient.domain;

import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: ShoppingCart
 * @author: Scarlet
 * @date: 2024/5/25
 **/
@Data
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Item> items;
    // paymentInfo 是敏感的支付信息，用 transient 修饰，不会被序列化。
    private transient String paymentInfo;

    //mallName 是静态变量，表示全局商场名称，不会被序列化。
    public static String mallName = "Best Mall";
    //totalSpent 是静态变量，表示所有用户的总支出金额，不会被序列化。
    public static double totalSpent = 0;

    public ShoppingCart(String paymentInfo) {
        this.items = new ArrayList<>();
        this.paymentInfo = paymentInfo;
    }

    public void addItem(Item item) {
        items.add(item);
        totalSpent += item.getTotalPrice();
    }

    @Override
    public String toString() {
        return "ShoppingCart{items=" + items + ", paymentInfo='" + paymentInfo + "'}";
    }
}
