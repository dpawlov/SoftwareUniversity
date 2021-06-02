package StreamsFilesAndDirectories;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteEveryThirdLine05 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Dimitar\\Desktop\\input.txt";
        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);

        PrintStream printStream = new PrintStream("third-line-out.txt");

        int lineNumber = 0;

        while (scanner.hasNext()) {
            if (scanner.hasNext()) {
                lineNumber++;
                if (lineNumber % 3 == 0) {
               printStream.println(scanner.nextLine());
                } else {
                    scanner.nextLine();
                }
            }
        }
    }
}