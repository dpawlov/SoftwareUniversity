package ArraysExercises;

import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());

        int [] numbers = new int [numbersCount];

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int numbersInArray = Integer.parseInt(scanner.nextLine());
            numbers[i] = numbersInArray;
            sum += numbers[i];
        }
        for (int number : numbers) {
            System.out.print(number + " ");

        }
        System.out.println();
        System.out.println(sum);

    }
}
