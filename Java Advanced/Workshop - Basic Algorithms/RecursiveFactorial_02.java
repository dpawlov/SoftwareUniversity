package Workshop;

import java.util.Scanner;

public class RecursiveFactorial_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        long factorial = factorial(number);

        System.out.println(factorial);
    }

    private static long factorial(int number) {
        if (number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }
}