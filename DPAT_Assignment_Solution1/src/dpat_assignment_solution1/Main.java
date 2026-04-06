/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dpat_assignment_solution1;

/**
 *
 * @author yifen
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserManager um = new UserManager();
        FileManager fm = new FileManager();
        Scanner sc = new Scanner(System.in);

        // ================= LOGIN =================
        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = um.login(username, password);

        if (user == null) {
            System.out.println("Login failed.");
            return;
        }

        System.out.println("\nWelcome " + user.username);

        // ================= MAIN LOOP =================
        while (true) {
            
            fm.showDirectory();

            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. File Operations");
            System.out.println("2. Folder Operations");
            System.out.println("3. Enter Folder");
            System.out.println("4. Go Back Folder");

            if (user.role.equals("admin")) {
                System.out.println("5. User Operations");
            }

            System.out.println("0. Exit");

            System.out.print("Input: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ================= FILE MENU =================
                case 1 -> {
                    while (true) {

                        fm.showDirectory();
                        
                        System.out.println("\n--- FILE MENU ---");
                        System.out.println("1. Create File");
                        System.out.println("2. Read File");
                        System.out.println("3. Update File");
                        System.out.println("4. Delete File");
                        System.out.println("5. Rename File");
                        System.out.println("6. Back");

                        System.out.print("Input: ");
                        int c = sc.nextInt();
                        sc.nextLine();

                        switch (c) {
                            case 1 -> fm.createFile();
                            case 2 -> fm.readFile();
                            case 3 -> fm.updateFile();
                            case 4 -> fm.deleteFile();
                            case 5 -> fm.renameFile();
                            case 6 -> {
                                System.out.println("Back to main menu...");
                                break;
                            }
                        }

                        if (c == 6) break;
                    }
                }

                // ================= FOLDER MENU =================
                case 2 -> {
                    while (true) {

                        fm.showDirectory();
                        
                        System.out.println("\n--- FOLDER MENU ---");
                        System.out.println("1. Create Folder");
                        System.out.println("2. Delete Folder");
                        System.out.println("3. Rename Folder");
                        System.out.println("4. Back");

                        System.out.print("Input: ");
                        int c = sc.nextInt();
                        sc.nextLine();

                        switch (c) {
                            case 1 -> fm.createFolder();
                            case 2 -> fm.deleteFolder();
                            case 3 -> fm.renameFolder();
                            case 4 -> {
                                System.out.println("Back to main menu...");
                                break;
                            }
                        }

                        if (c == 4) break;
                    }
                }
                
                case 3 -> fm.enterFolder();
                case 4 -> fm.goBack();

                // ================= USER MENU (ADMIN ONLY) =================
                case 5 -> {
                    if (!user.role.equals("admin")) break;

                    while (true) {
                        
                        um.viewUsers();

                        System.out.println("\n--- USER MENU ---");
                        System.out.println("1. Add User");
                        System.out.println("2. Delete Users");
                        System.out.println("3. Back");

                        System.out.print("Input: ");
                        int c = sc.nextInt();
                        sc.nextLine();

                        switch (c) {
                            case 1 -> {
                                System.out.print("New username: ");
                                String u = sc.nextLine();

                                System.out.print("Password: ");
                                String p = sc.nextLine();

                                um.addUser(new User(u, p, "user"));
                            }

                            case 2 -> {
                                System.out.print("Username: ");
                                String u = sc.nextLine();
                                um.deleteUser(u);
                            }

                            case 3 -> {
                                System.out.println("Back to main menu...");
                                break;
                            }
                        }

                        if (c == 3) break;
                    }
                }

                // ================= EXIT =================
                case 0 -> {
                    System.out.println("Exiting system...");
                    return;
                }
            }
        }
    }
}