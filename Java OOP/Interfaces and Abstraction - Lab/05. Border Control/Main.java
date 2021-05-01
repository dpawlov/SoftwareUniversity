package Interfaces05lab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> cityOfRobots = new ArrayList<>();
        List<Identifiable> cityOfCitizen = new ArrayList<>();

        String input;

        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" ");
            if (tokens.length == 2) {
                Robot robot = new Robot(tokens[1], tokens[0]);
                cityOfRobots.add(robot);
            } else {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                cityOfCitizen.add(citizen);
            }
        }
        String lastDigit = scanner.nextLine();

        printFakeIdInCity(cityOfCitizen, lastDigit);
        printFakeIdInCity(cityOfRobots,lastDigit);
    }

    private static void printFakeIdInCity(List<Identifiable>list, String lastDigit) {
        for (Identifiable element : list) {
            if (element.getId().endsWith(lastDigit)) {
                System.out.println(element.getId());
            }
        }
    }
}
