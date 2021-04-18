package SetsAndMapsAdvanced;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Double> studentScores = new TreeMap<>();
        int rowCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rowCount; i++) {
            String studentName = scanner.nextLine();
            Double averageScore = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .average().getAsDouble();

            studentScores.put(studentName, averageScore);
        }
        for (String studentName : studentScores.keySet()) {
            System.out.println(studentName + " is graduated with " + studentScores.get(studentName));
        }
    }
}

