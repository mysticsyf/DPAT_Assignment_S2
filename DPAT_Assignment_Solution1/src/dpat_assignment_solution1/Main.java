/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dpat_assignment_solution1;

/**
 *
 * @author yifen
 */
public class Main {
    public static void main(String[] args) {

        // Change this value to test portability issue
        DataManager dm = new DataManager("local");

        dm.saveData("Hello World");
        System.out.println(dm.loadData());
    }
}