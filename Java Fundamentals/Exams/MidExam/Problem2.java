package MidExamSoftuni;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Mort")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    int addNumber = Integer.parseInt(tokens[1]);
                    numbersList.add(addNumber);
                    break;

                case "Remove":
                    int removeNumber = Integer.parseInt(tokens[1]);
                    numbersList.remove(Integer.valueOf(removeNumber));
                    break;

                case "Replace":
                    int numberValue = Integer.parseInt(tokens[1]);
                    int replaceNumber = Integer.parseInt(tokens[2]);

                    for (int i = 0; i < 1; i++) {
                        int numberValueOfIndex = numbersList.indexOf(numberValue);

                        numbersList.set(numberValueOfIndex, replaceNumber);
                    }
                    break;

                case "Collapse":
                    int collapsedNumber = Integer.parseInt(tokens[1]);

                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) < collapsedNumber) {
                            numbersList.remove(numbersList.get(i));
                            i--;
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        for (Integer integer : numbersList) {
            System.out.print(integer + " ");
        }
    }
}
