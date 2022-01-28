package com.company.RecursionBacktracing;

import java.util.Scanner;

public class RecursiveDrawing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printFigure(n);
    }

    static void printFigure(int n) {
        if (n == 0) {
            return;
        }

        printLineOfChars('*', n);
        System.out.println();
        printFigure(n - 1);
        printLineOfChars('#', n);
        System.out.println();
    }

    static void printLineOfChars(char symbol, int n) {
        if (n == 0) {
            return;
        }
        System.out.print(symbol);
        printLineOfChars(symbol, n - 1);
    }
}
