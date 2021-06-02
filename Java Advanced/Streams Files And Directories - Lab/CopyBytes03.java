package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class CopyBytes03 {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "C:\\Users\\Dimitar\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\3output.txt";

        try (
                FileInputStream fileInputStream = new FileInputStream(inputPath);
                FileOutputStream fileOutputStream = new FileOutputStream(outPath)
        ) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                String digits = String.valueOf(oneByte);
                if (oneByte == 32) {
                    fileOutputStream.write(' ');
                } else if (oneByte == 10) {
                    fileOutputStream.write('\n');
                } else {
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}