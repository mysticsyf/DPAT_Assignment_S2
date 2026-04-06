/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author yifen
 */
public class UpdateFileOp implements FileOp {

    public void execute(MyFile file) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter new content:");
            String content = sc.nextLine();

            FileWriter fw = new FileWriter(file.getFullPath());
            fw.write(content);
            fw.close();

            System.out.println("Updated.");

        } catch (Exception e) {
            System.out.println("Update error.");
        }
    }
}