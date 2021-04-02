package Exam4Prep;

import java.util.*;

public class NeedForSpeed03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> cars = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String carInput = scanner.nextLine();
            String [] tokens = carInput.split("\\|");
            String carModel = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            cars.put(carModel, Arrays.asList(mileage, fuel));
        }
       String commands = scanner.nextLine();
        while (!commands.equals("Stop")) {
            String [] tokens = commands.split(" : ");
            String command = tokens[0];

            switch (command) {
                case "Drive":
                    String carModel = tokens[1];
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    List<Integer> currentCarStats = cars.get(carModel);
                    int currentDistance = currentCarStats.get(0);
                    int currentFuel = currentCarStats.get(1);

                    if (currentFuel < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        currentCarStats.set(0, currentDistance + distance);
                        currentCarStats.set(1, currentFuel - fuel);
                        cars.put(carModel, currentCarStats);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carModel, distance, fuel);

                        if (currentCarStats.get(0) >= 100000) {
                            cars.remove(carModel);
                            System.out.printf("Time to sell the %s!%n", carModel);
                        }
                    }
                    break;
                case "Refuel":
                    String refuelCarModel = tokens[1];
                    int refuelFuelAmount = Integer.parseInt(tokens[2]);
                    int carCurrentFuel = cars.get(refuelCarModel).get(1);
                    if (refuelFuelAmount + carCurrentFuel > 75) {
                        cars.get(refuelCarModel).set(1, 75);
                        System.out.printf("%s refueled with %s liters%n", refuelCarModel, 75 - carCurrentFuel);
                    } else {
                        cars.get(refuelCarModel).set(1, carCurrentFuel + refuelFuelAmount);
                        System.out.printf("%s refueled with %d liters%n", refuelCarModel, refuelFuelAmount);
                    }

                    break;
                case "Revert":
                    String revertCarModel = tokens[1];
                    int revertKilometers = Integer.parseInt(tokens[2]);
                    int currentCarKm = cars.get(revertCarModel).get(0);
                    if (currentCarKm - revertKilometers < 10000) {
                        cars.get(revertCarModel).set(0, 10000);
                    } else {
                        cars.get(revertCarModel).set(0, currentCarKm - revertKilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", revertCarModel, revertKilometers);
                    }

                    break;

            }
            commands = scanner.nextLine();
        }

        cars.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue().get(0) - a.getValue().get(0);
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
