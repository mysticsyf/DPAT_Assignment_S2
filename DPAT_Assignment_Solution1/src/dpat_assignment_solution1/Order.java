/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution1;

/**
 *
 * @author yifen
 */
import java.util.*;

public class Order {
    private int orderId;
    private List<Item> items = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private double total = 0;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void addItem(Item item, int quantity) {
        items.add(item);
        quantities.add(quantity);
        item.reduceStock(quantity);
    }

    public void calculateTotal() {
        total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }
    }

    public double getTotal() {
        return total;
    }

    public int getOrderId() {
        return orderId;
    }
}