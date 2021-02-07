package MethodsLab;

import java.util.Scanner;

public class Calculations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
            commandAdd(numberOne,numberTwo);
            break;
            case "multiply":
            commandMultiply(numberOne, numberTwo);
            break;
            case "subtract":
            commandSubtract(numberOne, numberTwo);
            break;
            case "divide":
            commandDivide(numberOne, numberTwo);
            break;
        }
    }


    private static void commandDivide(int firstNumber, int secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }

    private static void commandSubtract(int firstNumber, int secondNumber) {
        System.out.println(firstNumber - secondNumber);
    }

    private static void commandMultiply(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    private static void commandAdd(int firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }
}
