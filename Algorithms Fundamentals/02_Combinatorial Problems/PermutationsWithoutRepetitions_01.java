package com.company;

import java.util.Scanner;

public class PermutationsWithoutRepetitions_01 {
    public static String[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        permute(0);

    }

    static void permute(int index) {
        if (index >= elements.length) {
            System.out.println(String.join(" ", elements));
            return;
        }

        permute(index + 1);

        for (int i = index + 1; i < elements.length; i++) {
            swap(elements, index, i);
            permute(index + 1);
            swap(elements, index, i);
        }
    }

     static void swap(String[] elements, int firstIndex, int secondIndex) {
        String temp = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = temp;
    }
}
