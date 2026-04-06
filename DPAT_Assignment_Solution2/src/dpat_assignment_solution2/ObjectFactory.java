/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
public class ObjectFactory {

    public static User createUser(String username, String password) {
        return new User(username, password);
    }

    public static Item createItem(int id, String name, double price, int stock) {
        return new Item(id, name, price, stock);
    }

    public static Order createOrder(int orderId) {
        return new Order(orderId);
    }
}