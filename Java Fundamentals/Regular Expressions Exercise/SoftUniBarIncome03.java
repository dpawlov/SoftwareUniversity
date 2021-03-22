package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>\\d+)\\|[^|$%.]*?(?<price>[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {

                String customerName = matcher.group("customer");
                String productName = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = quantity * price;

                System.out.printf("%s: %s - %.2f%n", customerName, productName, totalPrice);
                totalIncome += totalPrice;
            }
            input = scanner.nextLine();

        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
