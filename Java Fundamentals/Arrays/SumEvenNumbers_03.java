package Arrays;

import java.util.Scanner;

public class SumEvenNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayAsString = scanner.nextLine().split(" ");
        int[] numbers = new int[arrayAsString.length];

        int sum = 0;

        for (int i = 0; i < arrayAsString.length; i++) {
            numbers[i] = Integer.parseInt(arrayAsString[i]);

            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }

}
