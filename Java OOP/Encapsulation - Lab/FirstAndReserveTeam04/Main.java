package Encapsulation04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Team team = new Team("Arsenal");

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person p = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]));

            team.addPlayer(p);

        }
        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());
    }
}
