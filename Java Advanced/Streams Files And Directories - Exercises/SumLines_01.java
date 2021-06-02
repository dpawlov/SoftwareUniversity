package StreamsFilesAndDirectoriesExercises;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumLines_01 {
    public static void main(String[] args) {
        String path = ("C:\\Users\\Dimitar\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        Files.readAllLines(Path.of(path)).stream()
                .map(String :: toCharArray)  //str -> str.toCharArray
                .forEach(charArray ->
                {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}