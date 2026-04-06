/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution1;

/**
 *
 * @author yifen
 */
public class LocalStorage {

    private String filePath = "local_file.txt";

    public void write(String data) {
        System.out.println("Writing to LOCAL storage: " + data);
    }

    public String read() {
        return "Reading from LOCAL storage";
    }
}