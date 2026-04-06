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

public class DeleteFolderOp implements FileOp {
    @Override
    public void execute(String currentPath) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Folder name to delete: ");
        String name = sc.nextLine();
        File f = new File(currentPath + name);
        if (f.exists() && f.isDirectory() && f.delete()) {
            System.out.println("Folder deleted.");
        } else {
            System.out.println("Failed to delete (folder might not be empty or doesn't exist).");
        }
    }
}