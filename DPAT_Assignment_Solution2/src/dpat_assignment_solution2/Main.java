/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
import java.util.Scanner;
import java.io.File;

public class Main {
    private static String currentPath = "data/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager um = new UserManager();
        FileManager fm = new FileManager();

        // ================= LOGIN =================
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = um.login(username, password);
        if (user == null) {
            System.out.println("Login failed. System exiting.");
            return;
        }
        System.out.println("\nWelcome " + user.username);

        // ================= MAIN LOOP =================
        while (true) {
            showDirectory();

            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. File Operations");
            System.out.println("2. Folder Operations");
            System.out.println("3. Enter Folder");
            System.out.println("4. Go Back Folder");
            if (user.role.equals("admin")) System.out.println("5. User Operations");
            System.out.println("0. Exit");
            System.out.print("Input: ");
            
            int choice = getIntInput(sc);

            switch (choice) {
                case 1 -> fileMenu(sc, fm);
                case 2 -> folderMenu(sc, fm);
                case 3 -> enterFolder(sc);
                case 4 -> goBack();
                case 5 -> {
                    if (user.role.equals("admin")) userMenu(sc, um, fm);
                    else System.out.println("Invalid choice.");
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void fileMenu(Scanner sc, FileManager fm) {
        while (true) {
            showDirectory();
            System.out.println("\n--- FILE MENU ---");
            System.out.println("1. Create File\n2. Read File\n3. Update File\n4. Delete File\n5. Rename File\n6. Back");
            System.out.print("Input: ");
            int c = getIntInput(sc);
            if (c == 6) break;

            System.out.print("Enter file name: ");
            String name = sc.nextLine();
            MyFile file = FileFactory.createFile(name, currentPath);

            switch (c) {
                case 1 -> fm.setStrategy(new CreateFileOp());
                case 2 -> fm.setStrategy(new ReadFileOp());
                case 3 -> fm.setStrategy(new UpdateFileOp());
                case 4 -> fm.setStrategy(new DeleteFileOp());
                case 5 -> fm.setStrategy(new RenameFileOp());
                default -> { 
                    System.out.println("Invalid Option");
                    continue; 
                }
            }
            fm.execute(file.getFullPath());
        }
    }

    private static void folderMenu(Scanner sc, FileManager fm) {
        while (true) {
            showDirectory();
            System.out.println("\n--- FOLDER MENU ---");
            System.out.println("1. Create Folder\n2. Delete Folder\n3. Rename Folder\n4. Back");
            System.out.print("Input: ");
            int c = getIntInput(sc);
            if (c == 4) break;

            switch (c) {
                case 1 -> fm.setStrategy(new CreateFolderOp());
                case 2 -> fm.setStrategy(new DeleteFolderOp());
                case 3 -> fm.setStrategy(new RenameFolderOp());
                default -> { 
                    System.out.println("Invalid Option");
                    continue; 
                }
            }
            fm.execute(currentPath); // Pass the current directory
        }
    }

    private static void userMenu(Scanner sc, UserManager um, FileManager fm) {
        while (true) {
            um.viewUsers();
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. Add User\n2. Delete User\n3. Back");
            System.out.print("Input: ");
            int c = getIntInput(sc);
            if (c == 3) break;

            switch (c) {
                case 1 -> fm.setStrategy(new AddUserOp(um));
                case 2 -> fm.setStrategy(new DeleteUserOp(um));
                default -> { 
                    System.out.println("Invalid Option");
                    continue; 
                }
            }
            fm.execute(""); // Path is irrelevant for user ops
        }
    }

    private static int getIntInput(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void showDirectory() {
        File dir = new File(currentPath);
        if (!dir.exists()) dir.mkdirs();
        System.out.println("\n--- PATH: " + currentPath + " ---");
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) System.out.println((f.isDirectory() ? "[Folder] " : "[File] ") + f.getName());
        } else {
            System.out.println("Empty folder.");
        }
    }

    private static void enterFolder(Scanner sc) {
        System.out.print("Folder name: ");
        String name = sc.nextLine();
        File f = new File(currentPath + name);
        if (f.exists() && f.isDirectory()) currentPath += name + "/";
        else System.out.println("Folder not found.");
    }

    private static void goBack() {
        if (currentPath.equals("data/")) {
            System.out.println("Already at root directory.");
            return;
        }
        File f = new File(currentPath);
        String parent = f.getParent();
        if (parent != null) currentPath = parent.replace('\\', '/') + "/";
    }
}