/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
import java.io.File;
import java.util.Scanner;

public class RenameFolderOp implements FileOp {
    @Override
    public void execute(String currentPath) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Current folder name: ");
        String oldName = sc.nextLine();
        System.out.print("New folder name: ");
        String newName = sc.nextLine();

        File oldFolder = new File(currentPath + oldName);
        File newFolder = new File(currentPath + newName);

        if (oldFolder.exists() && oldFolder.isDirectory() && oldFolder.renameTo(newFolder)) {
            System.out.println("Folder renamed successfully.");
        } else {
            System.out.println("Rename failed.");
        }
    }
}