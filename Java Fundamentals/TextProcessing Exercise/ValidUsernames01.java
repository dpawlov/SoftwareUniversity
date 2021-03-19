package TextProcessing;

import java.util.Scanner;

public class ValidUsernames01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] usernames = text.split(", ");


        for (String username : usernames) {
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }

    }

    static boolean isValidUsername(String username) {
        boolean isValid = false;

        if (username.length() >= 3 && username.length() <= 16) {
            isValid = true;
        } else {
            return false;
        }
        for (int index = 0; index < username.length(); index++) {
            char currentSymbol = username.charAt(index);

            if (Character.isAlphabetic(currentSymbol) || currentSymbol == '-' || currentSymbol == '_') {
                isValid = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
