package StreamsFilesAndDirectoriesExercises;

import javafx.scene.shape.Path;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Dimitar\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String outputPath = "outputLine.txt";
        PrintWriter writer = new PrintWriter(outputPath);

        Files.readAllLines(Path.of(path))
                .forEach(line ->
                        writer.println(countRow++ + ". " + line));

        writer.close();

    }
}