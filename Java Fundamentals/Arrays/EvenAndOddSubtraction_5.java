package Arrays;

import java.util.Scanner;

public class EvenAndOddSubtraction_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] arrayAsString = scanner.nextLine().split(" ");

        int [] numbers = new int[arrayAsString.length];

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < arrayAsString.length; i++) {
            numbers[i] = Integer.parseInt(arrayAsString[i]);
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else if (numbers[i] % 2 != 0) {
                oddSum += numbers[i];
            }
        }
        int finalSum = evenSum - oddSum;
        System.out.println(finalSum);


    }
}
