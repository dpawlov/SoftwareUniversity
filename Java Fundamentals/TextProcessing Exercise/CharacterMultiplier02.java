package TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");

        String first = input[0];
        String second = input[1];

        int min = Math.min(first.length(), second.length());
        int max = Math.max(first.length(), second.length());

        int result = 0;

        for (int i = 0; i < max; i++) {
            if (i < min) {
                result += first.charAt(i) * second.charAt(i);

            } else if (first.length() == max) {
                result += first.charAt(i);
            } else {
                result += second.charAt(i);
            }
        }

        System.out.println(result);
    }
}