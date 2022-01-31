package com.company;

import java.util.Scanner;

public class CombinationsWithoutRepetition_05 {
    private static String[] elements;
    private static String[] currentCombination;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        int numberOfVariations = Integer.parseInt(scanner.nextLine());

        currentCombination = new String[numberOfVariations];

        combinations(0, 0);
    }


    private static void combinations(int index, int startIndex) {
        if (index >= currentCombination.length) {
            System.out.println(String.join(" ", currentCombination));
            return;
        }

        for (int i = startIndex; i < elements.length; i++) {
            currentCombination[index] = elements[i];
            combinations(index + 1, i + 1);
        }
    }
}