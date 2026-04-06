/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution2;

/**
 *
 * @author yifen
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String path = "data/";

        System.out.print("Enter file name: ");
        String name = sc.nextLine();

        MyFile file = FileFactory.createFile(name, path);
        FileManager fm = new FileManager();

        while (true) {

            System.out.println("\n1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Exit");

            int c = sc.nextInt();

            switch (c) {
                case 1 -> fm.setStrategy(new CreateFileOp());
                case 2 -> fm.setStrategy(new ReadFileOp());
                case 3 -> fm.setStrategy(new UpdateFileOp());
                case 4 -> fm.setStrategy(new DeleteFileOp());
                case 0 -> { return; }
            }

            fm.execute(file);
        }
    }
}