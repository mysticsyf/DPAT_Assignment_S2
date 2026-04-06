/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
import java.io.*;
import java.util.*;

public class FileManager {

    public static boolean fileExists(String filename) {
        return new File(filename).exists();
    }

    public static void createFile(String filename) {
        try { new File(filename).createNewFile(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                users.add(ObjectFactory.createUser(d[0], d[1]));
            }
        } catch (Exception e) { e.printStackTrace(); }

        return users;
    }

    public static void saveUsers(List<User> users) {
        try (PrintWriter pw = new PrintWriter("users.txt")) {
            for (User u : users)
                pw.println(u.getUsername() + "," + u.getPassword());
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static List<Item> loadItems() {
        List<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                items.add(ObjectFactory.createItem(
                        Integer.parseInt(d[0]), d[1],
                        Double.parseDouble(d[2]),
                        Integer.parseInt(d[3])
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }

        return items;
    }

    public static void saveItems(List<Item> items) {
        try (PrintWriter pw = new PrintWriter("items.txt")) {
            for (Item i : items)
                pw.println(i.getItemId() + "," + i.getName() + ","
                        + i.getPrice() + "," + i.checkStock());
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void saveOrder(Order order) {
        try (FileWriter fw = new FileWriter("orders.txt", true)) {
            fw.write("OrderID:" + order.getOrderId() +
                    ",Total:" + order.getTotal() + "\n");
        } catch (Exception e) { e.printStackTrace(); }
    }
}