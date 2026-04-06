/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution1;

/**
 *
 * @author yifen
 */
public class CloudStorage {

    private String endpointURL = "https://cloud-storage.com/api";

    public void upload(String data) {
        System.out.println("Uploading to CLOUD: " + data);
    }

    public String download() {
        return "Downloading from CLOUD storage";
    }
}