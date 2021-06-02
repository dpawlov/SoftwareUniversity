package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile02 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Dimitar\\Desktop\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        String table = ",.!?";

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (!table.contains(String.valueOf(symbol))) {
                    System.out.print(symbol);
                }
            }
            System.out.println();
        }

    }
}

