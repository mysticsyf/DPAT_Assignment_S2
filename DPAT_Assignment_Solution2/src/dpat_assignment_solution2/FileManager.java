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

public class FileManager {

    private FileOp strategy;

    public void setStrategy(FileOp strategy) {
        this.strategy = strategy;
    }

    public void execute(MyFile file) {
        strategy.execute(file);
    }

    // ✅ MOVE FILE SHOULD BE HERE
    public void moveFile(MyFile file, Folder targetFolder) {

        File source = new File(file.getFullPath());
        File target = new File(
            targetFolder.getFullPath() + "\\" + file.getFileName()
        );

        if (source.renameTo(target)) {
            System.out.println("File moved successfully.");
        } else {
            System.out.println("Move failed.");
        }
    }
}