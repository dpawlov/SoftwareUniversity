package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetitions_02 {
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

        HashSet<String> swapped = new HashSet<>();
        swapped.add(elements[index]);
        permute(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            if (!swapped.contains(elements[i])) {
                swap(elements, index, i);
                permute(index + 1);
                swap(elements, index, i);
                swapped.add(elements[i]);
            }
        }
    }

    private static void swap(String[] elements, int firstIndex, int secondIndex) {
        String temp = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = temp;
    }
}