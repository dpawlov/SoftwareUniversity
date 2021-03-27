package MidExamSoftuni;

import java.util.*;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> itemsList = Arrays.stream(scanner.nextLine().split("\\:"))
                .collect(Collectors.toList());

        List<String> deck = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Ready")) {
            String [] tokens = input.split("\\s+");
            String command = tokens[0];


            switch (command) {
                case "Add":
                    String cardAdded = tokens[1];
                    if (itemsList.contains(cardAdded)) {
                        deck.add(cardAdded);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;

                case "Insert":
                    String cardInserted = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (index > deck.size() || index < 0) {
                        System.out.println("Error!");
                       break;
                    }
                    if (itemsList.contains(cardInserted)) {
                        deck.add(index, cardInserted);
                    } else {
                        System.out.println("Error!");
                    }

                    break;

                case "Swap":
                    String firstCard = tokens[1];
                    String secondCard = tokens[2];

                    int firstIndex = deck.indexOf(firstCard);
                    int secondIndex = deck.indexOf(secondCard);
                    if (firstIndex < 0 || secondIndex < 0 ) {
                        break;
                    } else {
                        Collections.swap(deck, firstIndex, secondIndex);
                    }
                break;

                case "Remove":
                    String cardToBeRemoved = tokens[1];
                    if (deck.contains(cardToBeRemoved)) {
                        deck.remove(cardToBeRemoved);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;

                case "Shuffle":
                    String shuffle = tokens[0];
                    Collections.reverse(deck);
                    break;
            }

            input = scanner.nextLine();
        }

        for (String currentCard : deck) {
            System.out.print(currentCard + " ");
        }
    }
}
