package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        int cycle = 1;

        for (String child : children)
            queue.offer(child);

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)

                queue.offer(queue.poll());

            if (isPrime(cycle))

                System.out.println("Prime " + queue.peek());

            else
                System.out.println("Removed " + queue.poll());
            cycle++;

        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
       if (cycle % 2 == 1) {
           return false;
       }
       return true;
    }
}
