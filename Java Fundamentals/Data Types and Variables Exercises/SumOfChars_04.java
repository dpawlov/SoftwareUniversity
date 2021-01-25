package DataTypesAndVariables;

import java.util.Scanner;

public class SumOfChars_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countSymbols = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 1; i <= countSymbols ; i++) {
            char symbol = scanner.nextLine().charAt(0);
            sum += (int)symbol;

        }
        System.out.println("The sum equals: " + sum);
    }
}

