/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author yifen
 */
public class ReadFileOp implements FileOp {

    public void execute(MyFile file) {
        try {
            File f = new File(file.getFullPath());

            if (!f.exists()) {
                System.out.println("File not found.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            boolean empty = true;

            while ((line = br.readLine()) != null) {
                empty = false;
                System.out.println(line);
            }

            if (empty) {
                System.out.println("(Empty file)");
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Read error.");
        }
    }
}