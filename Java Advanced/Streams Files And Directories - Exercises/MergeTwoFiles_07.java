package StreamsFilesAndDirectoriesExercises;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws FileNotFoundException {
        String pathOne = "C:\\Users\\Dimitar\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String pathTwo = "C:\\Users\\Dimitar\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String outputPath = "outputMerge.txt";

        PrintWriter writer = new PrintWriter(outputPath);
        Files.readAllLines(Path.of(pathOne))
                .forEach(writer::println);
        Files.readAllLines(Path.of(pathTwo))
                .forEach(writer::println);

        writer.close();

    }
}