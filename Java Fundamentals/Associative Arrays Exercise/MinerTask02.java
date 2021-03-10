package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        Map<String, Integer> minerResources = new LinkedHashMap<>();

        while (!resource.equals("stop")) {

            int quantity =  Integer.parseInt(scanner.nextLine());
            if (!minerResources.containsKey(resource)) {
                minerResources.put(resource, quantity);
            } else {
                minerResources.put(resource, minerResources.get(resource) + quantity);
            }

            resource = scanner.nextLine();

        }
        minerResources.forEach((k, v) ->System.out.println(k + " -> " + v));
    }
}
