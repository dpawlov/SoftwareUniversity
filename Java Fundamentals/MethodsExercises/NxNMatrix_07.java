package MethodsExercise;

import java.util.Scanner;

public class NxNMatrix_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        printMatrixOfNumber(number);


    }

    private static void printMatrixOfNumber(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}
