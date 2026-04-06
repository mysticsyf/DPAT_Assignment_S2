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

public class DeleteUserOp implements FileOp {
    private UserManager um;
    public DeleteUserOp(UserManager um) { this.um = um; }

    @Override
    public void execute(String path) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username to delete: ");
        String u = sc.nextLine();
        um.deleteUser(u);
    }
}