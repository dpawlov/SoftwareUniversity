package ExamPrep5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreathCount = 0;
        int storedFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {

            int lili = lilies.pop();
            int rose = roses.poll();
            int sum = lili + rose;

            if (sum == 15) {
                wreathCount++;
            } else if (sum > 15) {
                lilies.push(lili - 2);
                roses.push(rose);
            } else if (sum < 15) {
                storedFlowers += sum;
            }
        }

        while (storedFlowers >= 15) {
            wreathCount++;
            storedFlowers = storedFlowers - 15;
        }

        if (wreathCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreathCount);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreathCount);
        }
    }
}
