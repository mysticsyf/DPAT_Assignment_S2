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

public class RenameFileOp implements FileOp {
    @Override
    public void execute(String path) {
        File oldFile = new File(path);
        if (!oldFile.exists()) {
            System.out.println("File not found.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new file name: ");
        String newName = sc.nextLine();
        
        File newFile = new File(oldFile.getParent() + "/" + FileFactory.createFile(newName, "").getName());
        
        if (oldFile.renameTo(newFile)) System.out.println("File renamed successfully.");
        else System.out.println("Failed to rename file.");
    }
}
