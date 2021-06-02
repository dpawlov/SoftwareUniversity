package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile01 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Dimitar\\Desktop\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}