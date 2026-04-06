/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

import java.io.File;

/**
 *
 * @author yifen
 */

public class DeleteFileOp implements FileOp {

    public void execute(MyFile file) {
        File f = new File(file.getFullPath());

        if (f.delete()) {
            System.out.println("Deleted.");
        } else {
            System.out.println("Delete failed.");
        }
    }
}