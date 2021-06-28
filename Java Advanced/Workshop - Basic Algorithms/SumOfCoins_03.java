package Workshop;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class SumOfCoins_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coinsLine = scanner.nextLine();

        LinkedHashMap<Integer, Integer> coinsUsage = new LinkedHashMap<>();

        Arrays.stream(coinsLine
                .replaceAll("Coins: ", "")
                .split(", "))
                .map(Integer::parseInt)
                .sorted((f, s) -> Integer.compare(s, f))
                .forEach((num) -> coinsUsage.put(num, 0));

        String[] line = scanner.nextLine().split(": ");
        int sum = Integer.parseInt(line[1]);

        int totalCount = 0;

        for (Integer coinValue : coinsUsage.keySet()) {
            int count = sum / coinValue;
            coinsUsage.replace(coinValue, count);

            totalCount += count;
            sum -= count * coinValue;
        }
        if (sum > 0) {
            System.out.println("Error");
            return;
        }

        System.out.println("Number of coins to take: " + totalCount);
        coinsUsage
                .entrySet()
                .stream()
                .filter((entry) -> entry.getValue() != 0)
                .forEach((entry) -> System.out.println(
                        entry.getValue() + " coin(s) with value " + entry.getKey()));
    }
}