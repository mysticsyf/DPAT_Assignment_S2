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
    static Scanner sc = new Scanner(System.in);
    static FileManager fm = new FileManager();

    public static void main(String[] args) {

        // default user
        users.add(new User("admin", "1234"));

        if (login()) {
            menu();
        } else {
            System.out.println("Login Failed");
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

        while (true) {
            System.out.println("\n1. Create File");
            System.out.println("2. Write File");
            System.out.println("3. Read File");
            System.out.println("4. Update File");
            System.out.println("5. Delete File");
            System.out.println("6. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.print("Enter file name: ");
            String name = sc.nextLine();

            // ❗ HARD CODED PATH (for portability testing later)
            String path = "C:\\file_system\\";

            MyFile file = new MyFile(name, path);

            if (choice == 1) {
                fm.createFile(file);
            }
            else if (choice == 2) {
                System.out.print("Content: ");
                String content = sc.nextLine();
                fm.writeFile(file, content);
            }
            else if (choice == 3) {
                fm.readFile(file);
            }
            else if (choice == 4) {
                System.out.print("New Content: ");
                String content = sc.nextLine();
                fm.updateFile(file, content);
            }
            else if (choice == 5) {
                fm.deleteFile(file);
            }
            else if (choice == 6) {
                break;
            }
        }
    }
}