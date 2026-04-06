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

public class CreateFolderOp implements FileOp {
    @Override
    public void execute(String currentPath) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Folder name: ");
        String name = sc.nextLine();
        File f = new File(currentPath + name);
        if (f.mkdir()) System.out.println("Folder created.");
        else System.out.println("Failed to create folder.");
    }
}