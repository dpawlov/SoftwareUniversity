package Exam2;

import java.util.Scanner;

public class PasswordReset01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            StringBuilder sb = new StringBuilder();

            switch (command) {
                case "TakeOdd":
                    for (int i = 0; i < password.length(); i++) {
                        char currentChar = password.charAt(i);
                        if (i % 2 != 0) {
                            sb.append(currentChar);
                        }
                    }
                    password = sb.toString();
                    System.out.println(password);
                    break;

                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);

                    String firstPart = password.substring(0, index);
                    String secondPart = password.substring(index + length);
                    password = firstPart + secondPart;
                    System.out.println(password);
                    break;

                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    if (password.contains(substring)) {
                        password = password.replaceAll(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }
}