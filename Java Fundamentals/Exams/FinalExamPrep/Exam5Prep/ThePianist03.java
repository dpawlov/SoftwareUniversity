package Exam5Prep;

import java.util.*;

public class ThePianist03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> pianoPieces = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            pianoPieces.put(piece, Arrays.asList(composer, key));
        }

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Stop")) {
            String[] tokens = inputLine.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String addedPiece = tokens[1];
                    String addedComposer = tokens[2];
                    String addedKey = tokens[3];
                    if (!pianoPieces.containsKey(addedPiece)) {
                        pianoPieces.put(addedPiece, Arrays.asList(addedComposer, addedKey));
                        System.out.printf("%s by %s in %s added to the collection!%n", addedPiece, addedComposer, addedKey);
                    } else {
                        System.out.printf("%s is already in the collection!%n", addedPiece);
                    }
                    break;

                case "Remove":
                    String pieceToBeRemoved = tokens[1];
                    if (pianoPieces.containsKey(pieceToBeRemoved)) {
                        pianoPieces.remove(pieceToBeRemoved);
                        System.out.printf("Successfully removed %s!%n", pieceToBeRemoved);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToBeRemoved);
                    }
                    break;

                case "ChangeKey":
                    String pieceToBeChanged = tokens[1];
                    String newKey = tokens[2];
                    String currentComposer = pianoPieces.get(pieceToBeChanged).get(0);
                    if (pianoPieces.containsKey(pieceToBeChanged)) {
                        pianoPieces.remove(pianoPieces.get(pieceToBeChanged).get(1));
                        pianoPieces.put(pieceToBeChanged, Arrays.asList(currentComposer, newKey));
                        System.out.printf("Changed the key of %s to %s!%n", pieceToBeChanged, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.", pieceToBeChanged);
                    }
                    break;

            }
            inputLine = scanner.nextLine();
        }
        pianoPieces.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));
    }
}
