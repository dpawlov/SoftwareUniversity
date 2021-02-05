package ArraysExercises;

import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] arrayAsString = scanner.nextLine().split(" ");

        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            String temporary = arrayAsString[0];
            for (int j = 0; j < arrayAsString.length - 1; j++) {
                arrayAsString[j] = arrayAsString[j + 1];
            }
            arrayAsString[arrayAsString.length - 1] = temporary;
        }
        System.out.println(String.join(" ", arrayAsString));

    }
}
