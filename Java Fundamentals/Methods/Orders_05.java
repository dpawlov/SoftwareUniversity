package MethodsLab;

import java.util.Scanner;

public class Orders_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        totalPriceOfOrder(input, quantity);
    }

    private static void totalPriceOfOrder(String input, double quantity) {
        double totalPrice = 0;
        switch (input) {
            case "coffee":
                totalPrice = quantity * 1.50;
                break;
            case "water":
                totalPrice = quantity * 1.00;
                break;
            case "coke":
                totalPrice = quantity * 1.40;
                break;
            case "snacks":
                totalPrice = quantity * 2.00;
                break;
        }
        System.out.printf("%.2f",totalPrice);
    }
}
