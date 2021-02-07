package MethodsLab;

import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeatTimes = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatedString(input, repeatTimes));
    }

    private static String repeatedString(String input, int repeat) {
        for (int i = 1; i < repeat ; i++) {
            System.out.print(input);
        }
        return input;
    }
}
