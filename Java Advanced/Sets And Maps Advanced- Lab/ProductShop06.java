package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (!"Revision".equals(line = scanner.nextLine()
        )) {
            String[] data = line.split(", ");
            String shopName = data[0];
            String productName = data[1];
            Double productPrice = Double.parseDouble(data[2]);

            LinkedHashMap<String, Double> products = new LinkedHashMap<>();
            if (shops.containsKey(shopName)) {
                products = shops.get(shopName);
            }
            products.put(productName, productPrice);
            shops.put(shopName, products);
        }
        for (String shopName : shops.keySet()) {
            System.out.println(shopName + "->");
            LinkedHashMap<String, Double> products = shops.get(shopName);
            for (String productName : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productName, products.get(productName));
            }
        }

    }
}