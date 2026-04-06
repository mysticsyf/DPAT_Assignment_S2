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

    // SHOW DIRECTORY CONTENTS
    public void showDirectory() {
        File dir = new File(currentPath);

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
            System.out.print("File name: ");
            String name = sc.nextLine();

            File f = new File(currentPath + name + ".txt");
            f.createNewFile();

            System.out.println("File created.");
        } catch (Exception e) {}
    }

    // READ FILE
    public void readFile() {
        try {
            System.out.print("File name: ");
            String name = sc.nextLine();

            BufferedReader br = new BufferedReader(
                new FileReader(currentPath + name)
            );

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    // UPDATE FILE
    public void updateFile() {
        try {
            System.out.print("File name: ");
            String name = sc.nextLine();

            System.out.print("Content: ");
            String content = sc.nextLine();

            FileWriter fw = new FileWriter(currentPath + name);
            fw.write(content);
            fw.close();

            System.out.println("File updated.");

        } catch (Exception e) {}
    }

    // DELETE FILE
    public void deleteFile() {
        System.out.print("File name: ");
        String name = sc.nextLine();

        File f = new File(currentPath + name);

        if (f.delete()) {
            System.out.println("File deleted.");
        } else {
            System.out.println("Delete failed.");
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
            System.out.println("Failed.");
        }
    }

    // DELETE FOLDER
    public void deleteFolder() {
        System.out.print("Folder name: ");
        String name = sc.nextLine();

        File f = new File(currentPath + name);

        if (f.delete()) {
            System.out.println("Folder deleted.");
        } else {
            System.out.println("Failed (folder must be empty).");
        }
    }

    // ENTER FOLDER
    public void enterFolder() {
        System.out.print("Folder name: ");
        String name = sc.nextLine();

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
            System.out.println("Already at root.");
            return;
        }

        File f = new File(currentPath);
        String parent = f.getParent();

        if (parent != null) {
            currentPath = parent + "/";
            System.out.println("Back to: " + currentPath);
        }
    }
}