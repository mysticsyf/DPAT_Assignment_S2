/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
public class FolderManager {

    private FolderOp strategy;

    public void setStrategy(FolderOp strategy) {
        this.strategy = strategy;
    }

    public void execute(Folder folder) {
        strategy.execute(folder);
    }
}