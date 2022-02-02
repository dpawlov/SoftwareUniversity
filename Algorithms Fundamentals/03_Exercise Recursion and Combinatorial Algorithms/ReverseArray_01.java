package com.company;

import java.util.Scanner;

public class ReverseArray_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] array = scanner.nextLine().split("\\s+");

        reverseArray(array, array.length - 1);

    }

    static void reverseArray(String [] array, int index) {
        if (index < 0) {
            return;
        }

        System.out.printf("%s ", array[index]);
        reverseArray(array, index - 1);
    }
}
