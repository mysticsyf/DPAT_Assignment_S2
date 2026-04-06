/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
public class FileManager {
    private FileOp strategy;

    public void setStrategy(FileOp strategy) {
        this.strategy = strategy;
    }

    public void execute(String path) {
        if (strategy != null) {
            strategy.execute(path);
        }
    }
}