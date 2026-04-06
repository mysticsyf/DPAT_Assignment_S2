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
import java.util.Scanner;

public class FileManager {

    private String currentPath = "data/";
    private Scanner sc = new Scanner(System.in);

    // Helper method to automatically add .txt if the user forgets it
    private String formatFileName(String name) {
        if (!name.toLowerCase().endsWith(".txt")) {
            return name + ".txt";
        }
        return name;
    }

    // SHOW DIRECTORY CONTENTS
    public void showDirectory() {
        File dir = new File(currentPath);

        // Ensure directory exists
        if (!dir.exists()) {
            dir.mkdirs();
        }

        System.out.println("\n--- CURRENT PATH: " + currentPath + " ---");

        File[] files = dir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Empty folder.");
            return;
        }

        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("[Folder] " + f.getName());
            } else {
                System.out.println("[File] " + f.getName());
            }
        }
    }

    // CREATE FILE
    public void createFile() {
        try {
            System.out.print("Enter file name: ");
            String fileName = formatFileName(sc.nextLine());

            File file = new File(currentPath + fileName);

            if (file.createNewFile()) {
                System.out.println("File created successfully.");
                System.out.println("Enter file content (type END to stop):");

                // Try-with-resources automatically closes the writer
                try (FileWriter fw = new FileWriter(file)) {
                    while (true) {
                        String line = sc.nextLine();
                        if (line.equalsIgnoreCase("END")) break;
                        fw.write(line + "\n");
                    }
                }
                System.out.println("Content saved.");
            } else {
                System.out.println("File already exists.");
            }

        } catch (Exception e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
    
    // READ FILE
    public void readFile() {
        try {
            System.out.print("Enter file name: ");
            String fileName = formatFileName(sc.nextLine());

            File file = new File(currentPath + fileName);

            if (!file.exists()) {
                System.out.println("File not found.");
                return;
            }

            System.out.println("\n--- FILE CONTENT ---");
            boolean isEmpty = true;

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    isEmpty = false;
                    System.out.println(line);
                }
            }

            if (isEmpty) {
                System.out.println("(This file is empty)");
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // UPDATE FILE
    public void updateFile() {
        try {
            System.out.print("Enter file name to update: ");
            String name = formatFileName(sc.nextLine());
            
            File file = new File(currentPath + name);
            if (!file.exists()) {
                System.out.println("File not found. Please create it first.");
                return;
            }

            System.out.println("Enter file content to APPEND (type END to stop):");

            // true parameter in FileWriter enables "append" mode
            try (FileWriter fw = new FileWriter(file, true)) {
                while (true) {
                    String line = sc.nextLine();
                    if (line.equalsIgnoreCase("END")) break;
                    fw.write(line + "\n");
                }
            }

            System.out.println("File updated.");

        } catch (Exception e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
    }

    // DELETE FILE
    public void deleteFile() {
        System.out.print("Enter file name to delete: ");
        String name = formatFileName(sc.nextLine());

        File f = new File(currentPath + name);

        if (f.exists() && f.delete()) {
            System.out.println("File deleted.");
        } else {
            System.out.println("Delete failed. File might not exist.");
        }
    }
    
    // RENAME FILE
    public void renameFile() {
        try {
            System.out.print("Enter current file name: ");
            String oldName = formatFileName(sc.nextLine());

            System.out.print("Enter new file name: ");
            String newName = formatFileName(sc.nextLine());

            File oldFile = new File(currentPath + oldName);
            File newFile = new File(currentPath + newName);

            if (oldFile.exists()) {
                if (oldFile.renameTo(newFile)) {
                    System.out.println("File renamed successfully.");
                } else {
                    System.out.println("Rename failed. A file with the new name might already exist.");
                }
            } else {
                System.out.println("File not found.");
            }

        } catch (Exception e) {
            System.out.println("Error renaming file: " + e.getMessage());
        }
    }

    // CREATE FOLDER
    public void createFolder() {
        System.out.print("Folder name: ");
        String name = sc.nextLine();

        File f = new File(currentPath + name);

        if (f.mkdir()) {
            System.out.println("Folder created.");
        } else {
            System.out.println("Failed to create folder. It might already exist.");
        }
    }

    // DELETE FOLDER
    public void deleteFolder() {
        System.out.print("Folder name: ");
        String name = sc.nextLine();

        File f = new File(currentPath + name);

        if (f.exists() && f.isDirectory()) {
            if (f.delete()) {
                System.out.println("Folder deleted.");
            } else {
                System.out.println("Failed (folder must be empty to delete).");
            }
        } else {
            System.out.println("Folder not found.");
        }
    }
    
    // RENAME FOLDER
    public void renameFolder() {
        try {
            System.out.print("Current folder name: ");
            String oldName = sc.nextLine();

            System.out.print("New folder name: ");
            String newName = sc.nextLine();

            File oldFolder = new File(currentPath + oldName);
            File newFolder = new File(currentPath + newName);

            if (oldFolder.exists() && oldFolder.isDirectory()) {
                if (oldFolder.renameTo(newFolder)) {
                    System.out.println("Folder renamed successfully.");
                } else {
                    System.out.println("Rename failed.");
                }
            } else {
                System.out.println("Folder not found.");
            }

        } catch (Exception e) {
            System.out.println("Error renaming folder: " + e.getMessage());
        }
    }

    // ENTER FOLDER
    public void enterFolder() {
        System.out.print("Folder name: ");
        String name = sc.nextLine();
        
        // Basic security to prevent directory traversal attacks (escaping the data folder)
        if (name.contains("..") || name.contains("/")) {
            System.out.println("Invalid folder name.");
            return;
        }

        File f = new File(currentPath + name);

        if (f.exists() && f.isDirectory()) {
            currentPath = currentPath + name + "/";
            System.out.println("Entered: " + name);
        } else {
            System.out.println("Folder not found.");
        }
    }

    // GO BACK
    public void goBack() {
        if (currentPath.equals("data/")) {
            System.out.println("Already at root directory.");
            return;
        }

        File f = new File(currentPath);
        String parent = f.getParent();

        if (parent != null) {
            // Because getParent() strips the trailing slash, we add it back
            currentPath = parent.replace('\\', '/') + "/";
            System.out.println("Back to: " + currentPath);
        }
    }
}