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

public class ReadFileOp implements FileOp {
    @Override
    public void execute(String path) {
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("File not found.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            System.out.println("--- Content ---");
            while ((line = br.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}