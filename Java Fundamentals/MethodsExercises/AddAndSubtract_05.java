package MethodsExercise;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(sumFirstTwoNumbers(firstNumber, secondNumber) - thirdNumber);

    }

    private static int sumFirstTwoNumbers(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }
}
