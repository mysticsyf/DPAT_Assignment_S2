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
    private String name;
    private String path;

    public MyFile(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getFullPath() {
        return path + "/" + name;
    }

    public String getName() {
        return name;
    }
}