import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int finalTask = Integer.parseInt(scanner.nextLine());

        while (!(tasks.peek() == finalTask)) {
            int task = tasks.peek();
            int thread = threads.poll();
            if (thread >= task) {
                tasks.pop();
            }
        }
        while ((tasks.peek() == finalTask)) {
            int task = tasks.pop();
            int thread = threads.peek();
            System.out.printf("Thread with value %d killed task %d%n", thread, task);

        }
        String output = "";
        for (Integer thread : threads) {
            output += String.format("%d ", thread);

        }
        System.out.println(output);
    }
}
