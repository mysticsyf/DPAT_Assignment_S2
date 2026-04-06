package dpat_assignment_solution2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yifen
 */
public class Folder {
    private String folderName;
    private String path;

    public Folder(String folderName, String path) {
        this.folderName = folderName;
        this.path = path;
    }

    public String getFullPath() {
        return path + folderName;
    }
}