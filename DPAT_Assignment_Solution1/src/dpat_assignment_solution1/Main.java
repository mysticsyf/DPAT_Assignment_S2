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

        // LOGIN
        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        User user = um.login(u, p);

        if (user == null) {
            System.out.println("Login failed.");
            return;
        }

        System.out.println("\nWelcome " + user.username);

        while (true) {

            fm.showDirectory();

            System.out.println("\n--- MENU ---");
            System.out.println("1. Create File");
            System.out.println("2. Read File");
            System.out.println("3. Update File");
            System.out.println("4. Delete File");
            System.out.println("5. Create Folder");
            System.out.println("6. Delete Folder");
            System.out.println("7. Enter Folder");
            System.out.println("8. Go Back");

            if (user.role.equals("admin")) {
                System.out.println("9. Add User");
                System.out.println("10. View Users");
            }

            System.out.println("0. Exit");

            System.out.print("Insert Number of Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> fm.createFile();
                case 2 -> fm.readFile();
                case 3 -> fm.updateFile();
                case 4 -> fm.deleteFile();
                case 5 -> fm.createFolder();
                case 6 -> fm.deleteFolder();
                case 7 -> fm.enterFolder();
                case 8 -> fm.goBack();

                case 9 -> {
                    if (user.role.equals("admin")) {
                        System.out.print("Username: ");
                        String nu = sc.nextLine();

                        System.out.print("Password: ");
                        String np = sc.nextLine();

                        um.addUser(new User(nu, np, "user"));
                    }
                }

                case 10 -> {
                    if (user.role.equals("admin")) {
                        um.viewUsers();
                    }
                }

                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }
}