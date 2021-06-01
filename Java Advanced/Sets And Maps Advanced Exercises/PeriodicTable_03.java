package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCompounds = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        for (int compound = 0; compound < countCompounds; compound++) {
            String chemicalCompound = scanner.nextLine();
            String [] chemicalElements = chemicalCompound.split("\\s+");

            elements.addAll(Arrays.asList(chemicalElements));

        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
