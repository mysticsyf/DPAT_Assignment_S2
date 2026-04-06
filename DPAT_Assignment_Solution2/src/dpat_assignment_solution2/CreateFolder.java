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

public class CreateFolder implements FolderOp {
    public void execute(Folder folder) {
        File dir = new File(folder.getFullPath());

        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("Folder created");
        }
    }
}