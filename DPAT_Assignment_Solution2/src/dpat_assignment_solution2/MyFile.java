/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
public class MyFile {
    private String fileName;
    private String path;

    public MyFile(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }

    public String getFullPath() {
        return path + fileName;
    }

    public String getFileName() {
        return fileName;
    }
}