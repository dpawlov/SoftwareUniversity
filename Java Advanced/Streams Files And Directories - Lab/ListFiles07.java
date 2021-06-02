package StreamsFilesAndDirectories;

import java.io.File;

public class ListFiles07 {
    public static void main(String[] args) {
        String path = "C:\\Users\\Dimitar\\Desktop\\input.txt";

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(String.format("%s: [%d]", file.getName(), file.length()));
            }
        }
    }
}