/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
public class Main {
    public static void main(String[] args) {

        FileManager manager = new FileManager();

        MyFile file = FileFactory.createFile("test.txt", "C:\\file_system\\");

        // WRITE
        manager.setStrategy(new WriteFile("Hello Strategy Pattern"));
        manager.execute(file);

        // READ
        manager.setStrategy(new ReadFile());
        manager.execute(file);

        // UPDATE
        manager.setStrategy(new UpdateFile("Updated Content"));
        manager.execute(file);

        // DELETE
        manager.setStrategy(new DeleteFile());
        manager.execute(file);
    }
}