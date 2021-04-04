package FundamentalsFinalExam;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> PetersStats = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Log out")) {
            String[] tokens = input.split(": ");
            String command = tokens[0];


            switch (command) {
                case "New follower":
                    String newFollowerName = tokens[1];
                    if (!PetersStats.containsKey(newFollowerName)) {
                        PetersStats.put(newFollowerName, 0);
                    }
                    break;

                case "Like":
                    String likedUsername = tokens[1];
                    int countLikes = Integer.parseInt(tokens[2]);

                    if (PetersStats.containsKey(likedUsername)) {
                        int currentLikes = PetersStats.get(likedUsername);
                        PetersStats.put(likedUsername, countLikes + currentLikes);
                    } else {
                        PetersStats.put(likedUsername, countLikes);
                    }
                    break;

                case "Comment":
                    String commentUsername = tokens[1];

                    if (PetersStats.containsKey(commentUsername)) {
                        int currentComments = PetersStats.get(commentUsername);
                        PetersStats.put(commentUsername, currentComments + 1);
                    } else {
                        PetersStats.put(commentUsername, 1);
                    }
                    break;

                case "Blocked":
                    String blockedUsername = tokens[1];

                    if (PetersStats.containsKey(blockedUsername)) {
                        PetersStats.remove(blockedUsername);
                    } else {
                        System.out.printf("%s doesn't exist.%n", blockedUsername);
                    }
                    break;
            }

            input = scanner.nextLine();

        }
        System.out.printf("%d followers%n", PetersStats.size());
        PetersStats.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue() - a.getValue();
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}