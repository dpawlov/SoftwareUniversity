package Arrays;

import java.util.Scanner;

public class CondenseArrayToNumber_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputs = scanner.nextLine().split(" ");
        int[] numbers = new int [inputs.length];

        for (int i = 0; i < inputs.length ; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);

        } while (numbers.length > 1) {
            int[] condensed = new int [numbers.length - 1];

            for (int i = 0; i < numbers.length - 1; i++) {
                condensed[i] = numbers[i] + numbers[i + 1];
            }

            numbers = condensed;
        }

        System.out.println(numbers[0]);
    }
}
