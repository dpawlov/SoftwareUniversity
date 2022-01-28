package com.company.RecursionBacktracing;

import java.util.Scanner;

public class RecursiveFactorial_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println(calFactorial(num));
    }

    static int calFactorial(int number) {
        if (number == 1) {
            return 1;
        }

        return number * calFactorial(number - 1);
    }
}
