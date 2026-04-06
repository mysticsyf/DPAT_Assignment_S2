/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author yifen
 */
public class CreateFileOp implements FileOp {

    public void execute(MyFile file) {
        try {
            File f = new File(file.getFullPath());

            if (f.createNewFile()) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter content (END to stop):");

                FileWriter fw = new FileWriter(f);

                while (true) {
                    String line = sc.nextLine();
                    if (line.equalsIgnoreCase("END")) break;
                    fw.write(line + "\n");
                }

                fw.close();
                System.out.println("File created.");

            } else {
                System.out.println("File already exists.");
            }

        } catch (Exception e) {
            System.out.println("Create error.");
        }
    }
}
