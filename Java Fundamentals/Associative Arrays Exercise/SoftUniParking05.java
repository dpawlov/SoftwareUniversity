package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> registeredUsers = new LinkedHashMap<>();

        int commentsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commentsCount; i++) {

            String [] tokens = scanner.nextLine().split(" ");

            String command = tokens[0];
            String userName = tokens[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = tokens[2];
                    if (!registeredUsers.containsKey(userName)) {
                        registeredUsers.put(userName, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", userName, licensePlateNumber);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", registeredUsers.get(userName));
                    }
                    break;
                case "unregister":
                    if (!registeredUsers.containsKey(userName)) {
                        System.out.printf("ERROR: user %s not found%n", userName);
                        break;
                    }
                    registeredUsers.remove(userName);
                    System.out.printf("%s unregistered successfully%n", userName);
                    break;
            }

        }

        registeredUsers.entrySet()
                .forEach(element ->
                        System.out.printf("%s => %s%n", element.getKey(), element.getValue())
                );

    }
}


