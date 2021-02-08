package MethodsLab;

import java.util.Scanner;

public class GreaterOfTwoValues_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int firstNumber = Integer.parseInt(scanner.nextLine());
                int secondNumber = Integer.parseInt(scanner.nextLine());
                System.out.println(printMaxInt(firstNumber, secondNumber));
                break;
            case "char":
                char x = scanner.nextLine().charAt(0);
                char y = scanner.nextLine().charAt(0);
                System.out.println(printMaxChar(x, y));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                System.out.println(printMaxString(firstString, secondString));

        }


    }
    private static int printMaxInt(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return firstNumber;
        }
        return secondNumber;
    }

    private static char printMaxChar(char x, char y) {
        if (x > y) {
            return x;
        } return y;

    }
    private static String printMaxString(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        } return second;
    }

    }

