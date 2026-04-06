/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dpat_assignment_solution1;

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

        // USERS
        if (!FileManager.fileExists("users.txt")) {
            FileManager.createFile("users.txt");
            users.add(new User("admin", "1234"));
            FileManager.saveUsers(users);
        } else {
            users = FileManager.loadUsers();
        }

        // ITEMS
        if (!FileManager.fileExists("items.txt")) {
            FileManager.createFile("items.txt");
            items.add(new Item(1, "Apple", 2.0, 10));
            items.add(new Item(2, "Bread", 3.5, 5));
            FileManager.saveItems(items);
        } else {
            items = FileManager.loadItems();
        }

        // ORDERS
        if (!FileManager.fileExists("orders.txt")) {
            FileManager.createFile("orders.txt");
        }
    }

    public static boolean login() {
        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        for (User user : users) {
            if (user.login(u, p)) {
                return true;
            }
        }
        return false;
    }

    public static void menu() {
        Order order = new Order(1);

        while (true) {
            System.out.println("\n1. Check Stock");
            System.out.println("2. Order Item");
            System.out.println("3. Checkout");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                for (Item item : items) {
                    System.out.println(item.getItemId() + " - " + item.getName()
                            + " Stock: " + item.checkStock());
                }
            }

            else if (choice == 2) {
                System.out.print("Enter Item ID: ");
                int id = sc.nextInt();

                System.out.print("Quantity: ");
                int qty = sc.nextInt();

                boolean found = false;

                for (Item item : items) {
                    if (item.getItemId() == id) {
                        found = true;

                        if (item.checkStock() >= qty) {
                            order.addItem(item, qty);
                            System.out.println("Item added!");
                        } else {
                            System.out.println("Not enough stock!");
                        }
                    }
                }

                if (!found) {
                    System.out.println("Item not found!");
                }
            }

            else if (choice == 3) {
                order.calculateTotal();
                System.out.println("Total: RM " + order.getTotal());

                FileManager.saveItems(items);
                FileManager.saveOrder(order);

                break;
            }
        }
    }
}