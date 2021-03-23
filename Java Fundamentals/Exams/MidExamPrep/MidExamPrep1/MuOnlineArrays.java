package Exam1;

import java.util.Scanner;

public class MuOnlineArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dungeonRooms = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;
        int reachedRoom = 0;

        boolean completedAllRooms = true;

        for (int i = 0; i < dungeonRooms.length; i++) {
            String[] tokens = dungeonRooms[i].split("\\s+");

            String command = tokens[0];
            int points = Integer.parseInt(tokens[1]);

            if (command.equals("potion")) {
                if (health + points > 100) {
                    int currentHealth = health;
                    System.out.printf("You healed for %d hp.%n", 100 - currentHealth);
                    health = 100;
                    System.out.println("Current health: 100 hp.");
                } else {
                    health = health + points;
                    System.out.printf("You healed for %d hp.%n", points);
                    System.out.printf("Current health: %d hp.%n", health);
                    reachedRoom++;
                }
            } else if (command.equals("chest")) {
                System.out.printf("You found %d bitcoins.%n", points);
                bitcoins = bitcoins + points;
                reachedRoom++;
            } else {
                health = health - points;
                if (health > 0) {
                    System.out.printf("You slayed %s.", command);
                    System.out.println();
                }
                reachedRoom++;
            }
            if (health <= 0) {
                System.out.printf("You died! Killed by %s.%n", command);
                System.out.printf("Best room: %d%n", reachedRoom);
                completedAllRooms = false;
                break;
            }
        }
        if (completedAllRooms) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }
    }
}
