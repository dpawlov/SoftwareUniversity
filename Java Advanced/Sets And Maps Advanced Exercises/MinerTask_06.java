package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String value = scanner.nextLine();
            if (resources.containsKey(input)) {
                resources.put(input, resources.get(input) + Integer.parseInt(value));
            } else {
                resources.put(input, Integer.parseInt(value));
            }
            input = scanner.nextLine();
        }
        for (String res : resources.keySet()) {
            System.out.println(res + " -> " + resources.get(res));
        }
    }
}