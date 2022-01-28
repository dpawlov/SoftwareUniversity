package com.company.RecursionBacktracing;

import java.util.Scanner;

public class GeneratingVectors_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] vector = new int[n];

        generateVec(vector, 0);
    }

    private static void generateVec(int[] vector, int index) {
        if (index >= vector.length) {
            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generateVec(vector, index + 1);
        }
    }
}