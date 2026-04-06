/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
public class UpdateFile implements FileOp {
    private String content;

    public UpdateFile(String content) {
        this.content = content;
    }

    public void execute(MyFile file) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter(file.getFullPath());
            fw.write(content);
            fw.close();
            System.out.println("Updated successfully.");
        } catch (Exception e) {
            System.out.println("Update error.");
        }
    }
}