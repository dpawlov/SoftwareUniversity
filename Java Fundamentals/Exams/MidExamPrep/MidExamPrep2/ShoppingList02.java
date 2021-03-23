package Exam2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <String> products = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String [] tokens = input.split(" ");
            String command = tokens[0];
            String item = tokens[1];

            if ("Urgent".equals(command)) {
                if (!products.contains(item)) {
                    products.add(0, item);
                }
            } else if ("Unnecessary".equals(command)) {
                if (products.contains(item)) {
                    products.remove(item);
                }
            } else if ("Correct".equals(command)) {
                String newItem = tokens[2];
                if (products.contains(item)) {
                    products.set(products.indexOf(item), newItem);
                }
            } else if ("Rearrange".equals(command)) {
                if (products.contains(item)) {
                    products.remove(item);
                    products.add(item);
                }
            }
            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", products));

    }
}
