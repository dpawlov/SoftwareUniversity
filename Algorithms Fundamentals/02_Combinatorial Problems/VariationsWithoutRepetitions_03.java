package com.company;

import java.util.Scanner;

public class VariationsWithoutRepetitions_03 {
    private static String[] elements;
    private static boolean[] usedElements;
    private static String[] currentVariation;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        usedElements = new boolean[elements.length];
        int numberOfVariations = Integer.parseInt(scanner.nextLine());

        currentVariation = new String[numberOfVariations];

        variations(0);
    }


    private static void variations(int index) {
        if (index >= currentVariation.length) {
            System.out.println(String.join(" ", currentVariation));
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!usedElements[i]) {
                usedElements[i] = true;
                currentVariation[index] = elements[i];
                variations(index + 1);
                usedElements[i] = false;
            }
        }
    }

    private static void swap(String[] elements, int firstIndex, int secondIndex) {
        String tempString = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = tempString;
    }
}