package Arrays;

import java.util.Scanner;

public class PrintNumbersInReverseOrder_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());

        int [] numbersArray = new int [numbersCount];

        for (int i = 0; i < numbersArray.length; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbersArray[i] = number;
        }
        for (int i = numbersArray.length - 1; i >= 0; i--) {
            System.out.println(numbersArray[i]);
        }
    }
}
