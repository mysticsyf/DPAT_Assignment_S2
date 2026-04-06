/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution1;

/**
 *
 * @author yifen
 */
import java.io.*;

public class UserManager {

    private String userFile = "users/users.txt";

    public UserManager() {
        initUsers();
    }

    public void initUsers() {
        try {
            File f = new File(userFile);

            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();

                try (FileWriter fw = new FileWriter(f)) {
                    fw.write("admin,1234,admin\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error initializing users: " + e.getMessage());
        }
    }

    public User login(String u, String p) {
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3 && data[0].equals(u) && data[1].equals(p)) {
                    return new User(data[0], data[1], data[2]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading user database.");
        }

        return null;
    }

    public void addUser(User user) {
        try {
            // Check if user exists
            try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data[0].equalsIgnoreCase(user.username)) {
                        System.out.println("User already exists. Cannot add duplicate.");
                        return;
                    }
                }
            }

            // Append new user
            try (FileWriter fw = new FileWriter(userFile, true)) {
                fw.write(user.username + "," + user.password + "," + user.role + "\n");
            }
            System.out.println("User added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }
    
    public void viewUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            String line;
            System.out.println("\n--- USERS ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error viewing users: " + e.getMessage());
        }
    }
    
    public void deleteUser(String username) {
        try {
            File inputFile = new File(userFile);
            File tempFile = new File("users/temp.txt");

            boolean found = false;

            try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                 FileWriter fw = new FileWriter(tempFile)) {

                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    // skip the user we want to delete
                    if (!data[0].equals(username)) {
                        fw.write(line + "\n");
                    } else {
                        found = true;
                    }
                }
            }

            // replace old file with new file
            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            } else {
                System.out.println("Failed to update user database.");
            }

            if (found) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }
}