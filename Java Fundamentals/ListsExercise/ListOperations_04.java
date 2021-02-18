package ListsExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            if (command.equals("Add")) {
                int numberToAdd = Integer.parseInt(tokens[1]);
                numbers.add(numberToAdd);

            } else if (command.equals("Remove")) {
                int numberToRemove = Integer.parseInt(tokens[1]);
                if (isValidate(numberToRemove, numbers.size())) {
                    numbers.remove(numberToRemove);
                } else {
                    System.out.println("Invalid index");
                }


            } else if (command.equals("Insert")) {

                int numberToBeInserted = Integer.parseInt(tokens[1]);
                int atIndex = Integer.parseInt(tokens[2]);
                    if (isValidate(atIndex, numbers.size())) {
                        numbers.add(atIndex, numberToBeInserted);
                    } else {
                        System.out.println("Invalid index");
                    }


            } else if (tokens[1].equals("left")) {
                int timesToShift = Integer.parseInt(tokens[2]);

                for (int index = 0; index < timesToShift; index++) {
                    int firstNumber = numbers.get(0);
                    numbers.remove(0);
                    numbers.add(firstNumber);
                }
            } else if (tokens[1].equals("right")) {
                int timesToShift = Integer.parseInt(tokens[2]);

                for (int index = 0; index < timesToShift; index++) {
                    int lastNumber = numbers.get(numbers.size() - 1);
                    numbers.remove(numbers.size() - 1);
                    numbers.add(0, lastNumber);
                }
            }

            input = scanner.nextLine();
        }

        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static boolean isValidate(int index, int length) {
        return index >= 0 && index < length;
    }
}

