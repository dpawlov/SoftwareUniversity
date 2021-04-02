package Exam4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int spaceIndex = Integer.parseInt(tokens[1]);
                    message = message.substring(0, spaceIndex) + " " + message.substring(spaceIndex, message.length());
                    System.out.println(message);
                    break;

                case "Reverse":
                    String substring = tokens[1];

                    if (message.contains(substring)) {
                        String reversedSubstring = new StringBuilder(substring).reverse().toString();
                        message = message.replaceFirst(Pattern.quote(substring), "") + reversedSubstring;
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    String changeSubstring = tokens[1];
                    String replacementString = tokens[2];
                    message = message.replaceAll(changeSubstring, replacementString);
                    System.out.println(message);
                    break;
            }


            input = scanner.nextLine();

        }

        System.out.printf("You have a new text message: %s", message);
    }
}
