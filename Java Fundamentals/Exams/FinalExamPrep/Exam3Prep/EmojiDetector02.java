package Exam3Prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String numberRegex = "\\d";

        Pattern numberPattern = Pattern.compile(numberRegex);
        Matcher numberMatcher = numberPattern.matcher(input);

        List<Integer> numberList = new ArrayList<>();
        while (numberMatcher.find()) {
            int number = Integer.parseInt(numberMatcher.group());
            numberList.add(number);
        }

        int coolThreshHoldSum = 1;
        for (int i = 0; i < numberList.size(); i++) {
            coolThreshHoldSum *= numberList.get(i);
        }

        String emojiRegex = "(?<separator>[\\\\*:])\\1(?<emoji>[A-Z][a-z]{2,})\\1\\1";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher emojiMatcher = emojiPattern.matcher(input);

        List <String> coolEmojis = new ArrayList<>();
        int countOfEmojies = 0;
        while (emojiMatcher.find()) {
            countOfEmojies++;
            String separator = emojiMatcher.group("separator");
            String emojiText = emojiMatcher.group("emoji");
            if (isEmojiCool(emojiText, coolThreshHoldSum)) {
                String fullEmoji = separator + separator + emojiText + separator + separator;
                coolEmojis.add(fullEmoji);
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThreshHoldSum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countOfEmojies);
        coolEmojis.stream().forEach(System.out::println);
    }


    public static boolean isEmojiCool(String emojiText, int coolnessThreshold) {
        int emojiCoolness = 0;
        for (int i = 0; i < emojiText.length(); i++) {
            char emojiChar = emojiText.charAt(i);
            emojiCoolness += emojiChar;
        }
        boolean isEmojiCool = emojiCoolness >= coolnessThreshold;
        return isEmojiCool;
    }
}
