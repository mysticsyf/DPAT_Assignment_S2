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

public class CreateFileOp implements FileOp {
    @Override
    public void execute(String path) {
        try {
            File f = new File(path);
            if (f.createNewFile()) {
                System.out.println("File created.");
                System.out.println("Enter content (type 'END' to finish):");
                Scanner sc = new Scanner(System.in);
                try (FileWriter fw = new FileWriter(f)) {
                    while (true) {
                        String line = sc.nextLine();
                        if (line.equalsIgnoreCase("END")) break;
                        fw.write(line + "\n");
                    }
                }
            } else System.out.println("File already exists.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}