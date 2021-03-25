package Exam3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String [] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "swap":
                    int swap1 = Integer.parseInt(tokens[1]);
                    int swap2 = Integer.parseInt(tokens[2]);

                    Collections.swap(numbers, swap1, swap2);
                    break;

                case "multiply":
                    int number1 = Integer.parseInt(tokens[1]);
                    int number2 = Integer.parseInt(tokens[2]);

                    numbers.set(number1, numbers.get(number1) * numbers.get(number2));
                    break;

                case "decrease":
                    for (int i = 0; i < numbers.size(); i++) {
                        int val = numbers.get(i);
                        numbers.set(i, (val-1));

                    }

            }
            input = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
