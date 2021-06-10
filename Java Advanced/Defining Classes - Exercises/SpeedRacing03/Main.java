package SpeedRacing03;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String model = tokens[1];
            double distance = Double.parseDouble(tokens[2]);
            Car car = cars.get(model);
            car.drive(distance);

            command = scanner.nextLine();
        }
        cars.values().forEach(System.out::println);
    }
}
