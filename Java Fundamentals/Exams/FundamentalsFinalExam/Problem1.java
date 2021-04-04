package FundamentalsFinalExam;

import java.util.Locale;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String decryptedMessage = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Finish")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Replace":
                    char x = tokens[1].charAt(0);
                    char y = tokens[2].charAt(0);
                    decryptedMessage = decryptedMessage.replace(x, y);
                    System.out.println(decryptedMessage);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    StringBuilder sb = new StringBuilder(decryptedMessage);

                    if (isValidSb(sb, startIndex) && isValidSb(sb, endIndex)) {
                        sb.replace(startIndex, endIndex + 1, "");
                        decryptedMessage = sb.toString();
                        System.out.println(decryptedMessage);
                    } else {
                        System.out.println("Invalid indices!");
                    }

                    break;

                case "Make":
                    if (tokens[1].equals("Upper")) {
                        decryptedMessage = decryptedMessage.toUpperCase(Locale.ROOT);
                        System.out.println(decryptedMessage);
                    } else if (tokens[1].equals("Lower")) {
                        decryptedMessage = decryptedMessage.toLowerCase(Locale.ROOT);
                        System.out.println(decryptedMessage);
                    }
                    break;

                case "Check":
                    String checkString = tokens[1];

                    if (decryptedMessage.contains(checkString)) {
                        System.out.printf("Message contains %s%n", checkString);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", checkString);
                    }
                    break;

                case "Sum":
                    int startSumIndex = Integer.parseInt(tokens[1]);
                    int endSumIndex = Integer.parseInt(tokens[2]);

                    if (isValidString(decryptedMessage, startSumIndex) && isValidString(decryptedMessage, endSumIndex)) {
                        String substring = decryptedMessage.substring(startSumIndex, endSumIndex + 1);
                        int sum = 0;
                        for (int i = 0; i < substring.length(); i++) {
                            char currentChar = substring.charAt(i);
                            sum += currentChar;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }

                    break;

            }

            input = scanner.nextLine();

        }

    }

    static boolean isValidSb(StringBuilder sb, int index) {
        return index >= 0 && index < sb.length();
    }

    static boolean isValidString(String string, int index) {
        return index >= 0 && index < string.length();
    }
}
