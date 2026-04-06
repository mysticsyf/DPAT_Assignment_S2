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
            System.out.println("Error initializing users.");
        }
    }

    public User login(String u, String p) {
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(u) && data[1].equals(p)) {
                    return new User(data[0], data[1], data[2]);
                }
            }
        } catch (Exception e) {}
        return null;
    }

    public void addUser(User user) {
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(user.username)) {
                    System.out.println("Error: User '" + user.username + "' already exists. Cannot add duplicate.");
                    return; 
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading user database to check for duplicates.");
            return;
        }

        
        try (FileWriter fw = new FileWriter(userFile, true)) {
            fw.write(user.username + "," + user.password + "," + user.role + "\n");
            System.out.println("User added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding user.");
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
            System.out.println("Error viewing users.");
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
                    if (!line.split(",")[0].equals(username)) {
                        fw.write(line + "\n");
                    } else {
                        found = true;
                    }
                }
            }
            if (inputFile.delete()) tempFile.renameTo(inputFile);
            if (found) System.out.println("User deleted.");
            else System.out.println("User not found.");
        } catch (Exception e) {
            System.out.println("Error deleting user.");
        }
    }
}