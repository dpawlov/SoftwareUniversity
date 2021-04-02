package Exam3Prep;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawActivationKey = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (rawActivationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rawActivationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    String upperOrLower = tokens[1];
                    int startFlipIndex = Integer.parseInt(tokens[2]);
                    int endFlipIndex = Integer.parseInt(tokens[3]);
                    if (upperOrLower.equals("Upper")) {
                        String upperSubstring = rawActivationKey.substring(startFlipIndex, endFlipIndex).toUpperCase(Locale.ROOT);
                        StringBuilder sbLower = new StringBuilder(rawActivationKey);
                        sbLower = sbLower.replace(startFlipIndex, endFlipIndex, upperSubstring);
                        rawActivationKey = sbLower.toString();
                        System.out.println(rawActivationKey);

                    } else if (upperOrLower.equals("Lower")) {
                        String lowerSubstring = rawActivationKey.substring(startFlipIndex, endFlipIndex).toLowerCase(Locale.ROOT);
                        StringBuilder sbUpper = new StringBuilder(rawActivationKey);
                        sbUpper = sbUpper.replace(startFlipIndex, endFlipIndex, lowerSubstring);
                        rawActivationKey = sbUpper.toString();
                        System.out.println(rawActivationKey);
                    }
                    break;

                case "Slice":
                    int startSliceIndex = Integer.parseInt(tokens[1]);
                    int endSliceIndex = Integer.parseInt(tokens[2]);
                    StringBuilder sbDelete = new StringBuilder(rawActivationKey);
                    sbDelete = sbDelete.replace(startSliceIndex, endSliceIndex, "");
                    rawActivationKey = sbDelete.toString();
                    System.out.println(rawActivationKey);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", rawActivationKey);
    }
}
