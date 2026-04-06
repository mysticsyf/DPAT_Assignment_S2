/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
import java.util.*;

public class Main {
    static List<User> users = new ArrayList<>();
    static List<Item> items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        initializeFiles();

        if (login()) {
            menu();
        } else {
            System.out.println("Login Failed!");
        }
    }

    public static void initializeFiles() {

        if (!FileManager.fileExists("users.txt")) {
            FileManager.createFile("users.txt");
            users.add(ObjectFactory.createUser("admin", "1234"));
            FileManager.saveUsers(users);
        } else users = FileManager.loadUsers();

        if (!FileManager.fileExists("items.txt")) {
            FileManager.createFile("items.txt");
            items.add(ObjectFactory.createItem(1, "Apple", 2.0, 10));
            items.add(ObjectFactory.createItem(2, "Bread", 3.5, 5));
            FileManager.saveItems(items);
        } else items = FileManager.loadItems();

        if (!FileManager.fileExists("orders.txt")) {
            FileManager.createFile("orders.txt");
        }
    }

    public static boolean login() {
        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        for (User user : users)
            if (user.login(u, p)) return true;

        return false;
    }

    public static void menu() {

        Order order = ObjectFactory.createOrder(1);

        while (true) {
            System.out.println("\n1. Check Stock");
            System.out.println("2. Order Item");
            System.out.println("3. Choose Pricing Strategy");
            System.out.println("4. Checkout");

            int choice = sc.nextInt();

            if (choice == 1) {
                for (Item item : items)
                    System.out.println(item.getItemId() + " - " +
                            item.getName() + " Stock: " + item.checkStock());
            }

            else if (choice == 2) {
                System.out.print("Item ID: ");
                int id = sc.nextInt();

                System.out.print("Qty: ");
                int qty = sc.nextInt();

                for (Item item : items) {
                    if (item.getItemId() == id && item.checkStock() >= qty) {
                        order.addItem(item, qty);
                        System.out.println("Added!");
                    }
                }
            }

            else if (choice == 3) {
                System.out.println("1. Normal");
                System.out.println("2. Discount");

                int type = sc.nextInt();

                if (type == 1)
                    order.setStrategy(new NormalPricing());
                else
                    order.setStrategy(new DiscountPricing());
            }

            else if (choice == 4) {
                order.calculateTotal();
                System.out.println("Total: RM " + order.getTotal());

                FileManager.saveItems(items);
                FileManager.saveOrder(order);
                break;
            }
        }
    }
}