package ListsExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        Collections.reverse(inputList);

        String toPrint = inputList.toString().replaceAll("[\\[\\]\\s+,]", " ").trim();

        inputList = Arrays.stream(toPrint.split("\\s+")).collect(Collectors.toList());

        for (String number : inputList) {
            System.out.print(number + " ");

        }

    }
}
