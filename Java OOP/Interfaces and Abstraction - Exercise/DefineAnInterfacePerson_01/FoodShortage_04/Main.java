package FoodShortage_04;

import MultipleImplementation_02.Birthable;
import MultipleImplementation_02.Identifiable;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String idOrGroup = tokens[2];
            Buyer buyer = null;

            if (tokens.length == 4) {
                String birthDate = tokens[3];
                buyer = new Citizen(name, age, idOrGroup, birthDate);
            } else if (tokens.length == 1) {
                buyer = new Rebel(name, age, idOrGroup);
            } else {
                throw new IllegalArgumentException("Wrong parameter count");
            }

            buyerList.add(buyer);
        }

        String name = scanner.nextLine();

        while (!name.equals("End")) {
            for (Buyer buyer : buyerList) {
                if (name.equals(buyer.getName())) {
                    buyer.buyFood();
                    break;
                }
            }
            name = scanner.nextLine();
        }
        int totalFood = 0;

        for (Buyer buyer : buyerList) {
            totalFood += buyer.getFood();
        }

        System.out.println(totalFood);
    }
}