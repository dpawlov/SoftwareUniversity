package StreamsFilesAndDirectoriesExercises;

import java.io.File;
import java.util.Objects;

public class GetFolderSize_08 {
    public static void main(String[] args) {
        String path = "C:\\Users\\Dimitar\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        File folder = new File(path);

        int folderSize = 0;
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);

    }
}