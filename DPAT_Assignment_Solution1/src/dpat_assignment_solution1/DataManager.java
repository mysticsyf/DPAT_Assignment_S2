/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution1;

/**
 *
 * @author yifen
 */
public class DataManager {

    private String storageType;
    private LocalStorage localStorage;
    private CloudStorage cloudStorage;

    public DataManager(String storageType) {
        this.storageType = storageType;
        this.localStorage = new LocalStorage();
        this.cloudStorage = new CloudStorage();
    }

    public void saveData(String data) {

        if (storageType.equalsIgnoreCase("local")) {
            localStorage.write(data);

        } else if (storageType.equalsIgnoreCase("cloud")) {
            cloudStorage.upload(data);

        } else {
            System.out.println("Invalid storage type");
        }
    }

    public String loadData() {

        if (storageType.equalsIgnoreCase("local")) {
            return localStorage.read();

        } else if (storageType.equalsIgnoreCase("cloud")) {
            return cloudStorage.download();

        } else {
            return "Invalid storage type";
        }
    }
}