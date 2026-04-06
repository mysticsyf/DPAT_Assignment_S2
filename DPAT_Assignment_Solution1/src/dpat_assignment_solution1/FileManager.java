/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpat_assignment_solution1;

/**
 *
 * @author yifen
 */
import java.io.*;

public class FileManager {

    public void createFile(MyFile file) {
        try {
            File f = new File(file.getFullPath());
            if (f.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("Error creating file.");
        }
    }

    public void writeFile(MyFile file, String content) {
        try {
            FileWriter fw = new FileWriter(file.getFullPath());
            fw.write(content);
            fw.close();
            System.out.println("Written to file.");
        } catch (Exception e) {
            System.out.println("Error writing file.");
        }
    }

    public void readFile(MyFile file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file.getFullPath()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    public void updateFile(MyFile file, String newContent) {
        writeFile(file, newContent); // overwrite
        System.out.println("File updated.");
    }

    public void deleteFile(MyFile file) {
        File f = new File(file.getFullPath());
        if (f.delete()) {
            System.out.println("File deleted.");
        } else {
            System.out.println("File not found.");
        }
    }
    
    public void createFolder(Folder folder) {
        File dir = new File(folder.getFullPath());

        if (dir.exists()) {
            System.out.println("Folder already exists.");
        } else {
            if (dir.mkdir()) {
                System.out.println("Folder created.");
            } else {
                System.out.println("Failed to create folder.");
            }
        }
    }
    
    public void deleteFolder(Folder folder) {
        File dir = new File(folder.getFullPath());

        if (dir.exists() && dir.isDirectory()) {
            if (dir.delete()) {
                System.out.println("Folder deleted.");
            } else {
                System.out.println("Folder not empty or failed to delete.");
            }
        } else {
            System.out.println("Folder not found.");
        }
    }
    
    public void moveFile(MyFile file, Folder targetFolder) {
        File source = new File(file.getFullPath());
        File target = new File(targetFolder.getFullPath() + "\\" + file.getFileName());

        if (source.renameTo(target)) {
            System.out.println("File moved successfully.");
        } else {
            System.out.println("Failed to move file.");
        }
    }
}