package Exam1;

import java.util.Scanner;

public class WorldTour01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] inputParts = input.split(":");
            String command = inputParts[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(inputParts[1]);
                    String addedString = inputParts[2];

                    if (isValid(sb, index)) {
                        sb.insert(index, addedString);
                    }
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(inputParts[1]);
                    int endIndex = Integer.parseInt(inputParts[2]);

                    if (isValid(sb, startIndex) && isValid(sb, endIndex)) {
                        sb.replace(startIndex, endIndex + 1, "");
                    }
                    break;

                case "Switch":
                    String oldString = inputParts[1];
                    String newString = inputParts[2];
                    sb = new StringBuilder(sb.toString().replace(oldString, newString));
                    break;
            }

            System.out.println(sb);
            input = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops:" + " " + sb);
    }

    static boolean isValid(StringBuilder sb, int index) {
        return index >= 0 && index < sb.length();
    }
}
