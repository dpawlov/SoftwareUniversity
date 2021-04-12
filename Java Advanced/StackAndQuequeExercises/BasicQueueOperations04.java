package StackAndQuequeExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N -> elements to push onto the stack
        // S -> elements to pop from the stack
        // X -> check if elements is in the stack
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] firstLine = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(firstLine[0]);
        int s = Integer.parseInt(firstLine[1]);
        int x = Integer.parseInt(firstLine[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        //n
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        //s
        for (int j = 0; j < s; j++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            if (queue.contains(x)) {
                System.out.println("true");
            } else {
                System.out.println(getMinNumber(queue));
            }
        }
    }

    private static int getMinNumber(ArrayDeque<Integer> queue) {
        int min = Integer.MAX_VALUE;
        for (Integer number : queue) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}

