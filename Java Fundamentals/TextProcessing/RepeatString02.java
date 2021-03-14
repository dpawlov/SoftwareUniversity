package TextProcessing;

import java.util.Scanner;

public class RepeatString02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        for (String word : words) {
            String repeatedWord = repeatedWord(word, word.length());

            System.out.print(repeatedWord);
        }
    }

    private static String repeatedWord(String word, int numberOfRepetitions) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numberOfRepetitions; i++) {
            result.append(word);
        }

        return result.toString();

    }

}
