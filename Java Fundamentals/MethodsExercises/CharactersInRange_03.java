package MethodsExercise;

import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char startSymbol = scanner.nextLine().charAt(0);
        char endSymbol = scanner.next().charAt(0);

        printSymbolsInRange(startSymbol, endSymbol);

    }

    static void printSymbolsInRange(char start, char end) {
        if (start < end) {
            for (int ascii = start + 1; ascii <= end - 1; ascii++) {
                System.out.print((char) ascii + " ");
            }
        } else {
            for (int ascii = end + 1; ascii <= start - 1; ascii++) {
                System.out.print((char) ascii + " ");
            }
        }
    }
}
