/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
import java.io.*;
import java.util.Scanner;

public class UpdateFileOp implements FileOp {
    @Override
    public void execute(String path) {
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("File not found.");
            return;
        }
        System.out.println("Enter content to append (type 'END' to finish):");
        Scanner sc = new Scanner(System.in);
        try (FileWriter fw = new FileWriter(f, true)) {
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("END")) break;
                fw.write(line + "\n");
            }
            System.out.println("File updated.");
        } catch (IOException e) {
            System.out.println("Error updating file.");
        }
    }
}