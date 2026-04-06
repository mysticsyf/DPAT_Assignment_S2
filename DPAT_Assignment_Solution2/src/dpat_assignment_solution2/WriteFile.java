/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
import java.io.*;

public class WriteFile implements FileOp {
    private String content;

    public WriteFile(String content) {
        this.content = content;
    }

    public void execute(MyFile file) {
        try {
            FileWriter fw = new FileWriter(file.getFullPath());
            fw.write(content);
            fw.close();
            System.out.println("Written successfully.");
        } catch (Exception e) {
            System.out.println("Write error.");
        }
    }
}