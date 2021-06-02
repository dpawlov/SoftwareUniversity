package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SortLines06 {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\Dimitar\\Desktop\\input.txt";
        String inputPath = basePath + "C:\\Users\\Dimitar\\Desktop\\input2.txt";
        String outPath = basePath + "C:\\Users\\Dimitar\\Desktop\\3output.txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(outPath))) {
            Files.readAllLines(Paths.get(inputPath))
                    .stream()
                    .filter(s -> !s.isEmpty())
                    .sorted()
                    .forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}