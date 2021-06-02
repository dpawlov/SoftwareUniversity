package StreamsFilesAndDirectories;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers04 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Dimitar\\Desktop\\input.txt";
        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}


