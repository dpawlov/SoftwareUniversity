package com.company;

import java.util.Scanner;

public class NestedLoopsToRecursion_02 {
    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nestedLoopsCount = Integer.parseInt(scanner.nextLine());

        array = new int[nestedLoopsCount];

        nestedLoopsData(0);
    }

    static void nestedLoopsData(int currentIndex) {
        if (currentIndex >= array.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int number : array) {
                stringBuilder.append(number).append(" ");
            }
            System.out.println(stringBuilder.toString().trim());
            return;
        }

        for (int i = 1; i <= array.length; i++) {
            array[currentIndex] = i;
            nestedLoopsData(currentIndex + 1);
            
        }
    }
}
