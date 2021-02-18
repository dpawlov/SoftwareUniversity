package ListsExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List <Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int firstIndex = 0;

        while (firstDeck.size() > 0 && secondDeck.size() > 0) {

            boolean isFirstBigger = firstDeck.get(firstIndex) > secondDeck.get(firstIndex);
            boolean isSecondBigger = secondDeck.get(firstIndex) > firstDeck.get(firstIndex);

            if (isFirstBigger) {
                firstDeck.add(secondDeck.get(firstIndex));
                firstDeck.add(firstDeck.size() - 1, firstDeck.get(firstIndex));
                firstDeck.remove(firstIndex);
                secondDeck.remove(firstIndex);
            } else if (isSecondBigger) {
                secondDeck.add(firstDeck.get(firstIndex));
                secondDeck.add(secondDeck.size() - 1, secondDeck.get(firstIndex));
                secondDeck.remove(firstIndex);
                firstDeck.remove(firstIndex);
            } else {
                firstDeck.remove(firstIndex);
                secondDeck.remove(firstIndex);
            }

        }

        int sumFirst = 0;
        if (secondDeck.isEmpty()) {
            for (int integer : firstDeck) {
                sumFirst += integer;
            }
        }

        int sumSecond = 0;
        if (firstDeck.isEmpty()) {
            for (int number : secondDeck) {
                sumSecond += number;

            }
        }

        String output = "";
        if (sumFirst > sumSecond) {
            output = String.format("First player wins! Sum: %d", sumFirst);
        } else if (sumSecond > sumFirst) {
            output = String.format("Second player wins! Sum: %d", sumSecond);
        }

        System.out.println(output);

    }
}