package ListsExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int specialNumber = scanner.nextInt();
        int power = scanner.nextInt();

        while (numbers.contains(specialNumber)) {

            int indexOfBomb = numbers.indexOf(specialNumber);
            int left = indexOfBomb - power;
            int right = indexOfBomb + power;

            if (left < 0) {
                left = 0;
            } else if (right > numbers.size() - 1) {
                right = numbers.size() - 1;
            }

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}

