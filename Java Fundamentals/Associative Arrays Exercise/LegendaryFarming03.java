package AssociativeArrays;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> items = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();

        items.put("fragments", 0);
        items.put("shards", 0);
        items.put("motes", 0);

        label:
        while (true) {
            String[] input = scanner.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < input.length; i++) {

                if (i % 2 != 0) {

                    switch (input[i]) {
                        case "fragments":
                        case "shards":
                        case "motes":
                            items.putIfAbsent(input[i], 0);
                            if (items.get(input[i]) + Integer.parseInt(input[i - 1]) >= 250) {
                                if (input[i].equals("fragments")) {
                                    System.out.println("Valanyr obtained!");
                                } else if (input[i].equals("shards")) {
                                    System.out.println("Shadowmourne obtained!");
                                } else {
                                    System.out.println("Dragonwrath obtained!");
                                }
                                items.put(input[i], items.get(input[i]) + Integer.parseInt(input[i - 1]) - 250);
                                break label;
                            }
                            items.put(input[i], items.get(input[i]) + Integer.parseInt(input[i - 1]));
                            break;

                        default:
                            junk.putIfAbsent(input[i], 0);
                            junk.put(input[i], junk.get(input[i]) + Integer.parseInt(input[i - 1]));
                    }
                }
            }
        }

        items.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(pair ->
                        System.out.printf("%s: %d%n", pair.getKey(), pair.getValue()));

        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}