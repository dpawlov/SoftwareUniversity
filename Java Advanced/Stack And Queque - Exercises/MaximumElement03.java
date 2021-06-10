package StackAndQuequeExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque <Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String [] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    int pushNumber = Integer.parseInt(tokens[1]);
                    queue.push(pushNumber);
                    break;

                case "2":
                    queue.pop();
                    break;

                case "3":
                    System.out.println(printMaxNumber(queue));
                    break;
            }

        }

    }

    private static int printMaxNumber(ArrayDeque<Integer> stack) {
        int min = Integer.MIN_VALUE;
        for (Integer number : stack) {
            if (number > min) {
                min = number;
            }
        }
        return min;
    }
}
