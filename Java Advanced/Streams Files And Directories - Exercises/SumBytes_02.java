package StreamsFilesAndDirectoriesExercises;

import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes_02 {
    public static void main(String[] args) {
        String path = ("C:\\Users\\Dimitar\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        long sum = 0;
        for(byte value : Files.readAllBytes(Path.of(path))){
            if (value != 10 && value != 13){
                sum += value;
            }
        }

        System.out.println(sum);
    }
}




