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

    private String userFile = "data/users.txt";

    public UserManager() {
        initUsers();
    }

    public void initUsers() {
        try {
            File f = new File(userFile);

            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();

                FileWriter fw = new FileWriter(f);
                fw.write("admin,1234,admin\n");
                fw.close();
            }

        } catch (Exception e) {
            System.out.println("Error initializing users.");
        }
    }

    public User login(String u, String p) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(userFile));
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
        try {
            FileWriter fw = new FileWriter(userFile, true);
            fw.write(user.username + "," + user.password + "," + user.role + "\n");
            fw.close();
        } catch (Exception e) {}
    }

    public void viewUsers() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(userFile));
            String line;

            System.out.println("\n--- USERS ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {}
    }
}