package com.example.cd_15ecommercebackend.Service;

import java.io.File;

public class DeleteFiles {

    public void run() {
        String path = "src/main/resources/static/";
        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.delete()) {
                            System.out.println("Deleted file: " + file.getName());
                        } else {
                            System.err.println("Failed to delete file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.err.println("Directory does not exist or is not a directory.");
        }
    }
}
