package ArraysExercises;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        int rows = scanner.nextInt();
        int coef = 1;

        for(int i = 0; i < rows; i++) {
            for(int sp = 1; sp < rows - i; ++sp) {
                System.out.print("  ");
            }

            for(int j = 0; j <= i; j++) {
                if (j == 0 || i == 0)
                    coef = 1;
                else
                    coef = coef * (i - j + 1) / j;

                System.out.printf("%4d", coef);
            }

            System.out.println();
        }
    }
}
