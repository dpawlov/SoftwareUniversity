package Exam5Prep;

import java.util.Scanner;

public class TheImitationGame01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedMessage = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String movingString = encryptedMessage.substring(0, numberOfLetters);
                    encryptedMessage = encryptedMessage.replace(movingString, "");

                    StringBuilder sbMove = new StringBuilder();
                    sbMove.append(encryptedMessage);
                    sbMove.append(movingString);
                    encryptedMessage = sbMove.toString();

                    break;

                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    StringBuilder sb = new StringBuilder();
                    sb.append(encryptedMessage);
                    sb.insert(index, value);
                    encryptedMessage = sb.toString();
                    break;

                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];

                    while (encryptedMessage.contains(substring)) {
                        encryptedMessage = encryptedMessage.replace(substring, replacement);
                    }
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }
}
