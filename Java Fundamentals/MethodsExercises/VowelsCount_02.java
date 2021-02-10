package MethodsExercise;

import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        printVowelsCount(text);

    }

    static void printVowelsCount(String text) {

        int count = 0;
        for (int index = 0; index <= text.length() - 1; index++) {

            char currentSymbol = text.charAt(index);
            switch (currentSymbol) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }
        System.out.println(count);
    }

}