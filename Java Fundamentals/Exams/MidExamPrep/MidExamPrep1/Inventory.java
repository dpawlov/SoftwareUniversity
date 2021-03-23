package Exam1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> itemsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            String[] tokens = command.split("\\s+");

            String action = tokens[0];
            String item = tokens[2];

            if (action.equals("Collect")) {
                if (!itemsList.contains(item)) {
                    itemsList.add(item);
                }
            } else if (action.equals("Drop")) {
                if (itemsList.contains(item)) {
                    itemsList.remove(item);
                }
            } else if (action.equals("Combine")) {
                tokens = command.split("(\\s+)");
                String [] itemsToBeCombined = tokens[3].split(":");
                String oldItem = itemsToBeCombined[0];
                String newItem = itemsToBeCombined[1];
                for (int i = 0; i < itemsList.size(); i++) {
                    if (itemsList.get(i).equals(oldItem)) {
                        itemsList.add(i + 1, newItem);
                    }
                }
            } else if (action.equals("Renew")) {
                if (itemsList.contains(item)) {
                    itemsList.remove(item);
                    itemsList.add(item);

                }
            }
            command = scanner.nextLine();
        }

        System.out.println(itemsList.toString().replaceAll("[\\[\\]]", ""));

        }
    }

