/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
public class FileFactory {
    public static MyFile createFile(String name, String path) {
        if (!name.toLowerCase().endsWith(".txt")) {
            name += ".txt";
        }
        return new MyFile(name, path);
    }

    public static Folder createFolder(String name, String path) {
        return new Folder(name, path);
    }
}