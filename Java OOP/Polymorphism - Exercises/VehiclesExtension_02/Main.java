package VehiclesExtension_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicles car = createVehicle(scanner);
        Vehicles truck = createVehicle(scanner);
        Bus bus = (Bus) createVehicle(scanner);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] lines = scanner.nextLine().split("\\s+");
            String command = lines[0];
            String vehicleType = lines[1];
            double value = Double.parseDouble(lines[2]);
            try {
                if (command.equals("Drive")) {
                    if (vehicleType.equals("Car")) {
                        System.out.println(car.drive(value));
                    } else if (vehicleType.equals("Truck")) {
                        System.out.println(truck.drive(value));
                    } else if (vehicleType.equals("Bus")) {
                        System.out.println(bus.drive(value));
                    }
                } else if (command.equals("Refuel")) {
                    if (vehicleType.equals("Car")) {
                        car.refuel(value);
                    } else if (vehicleType.equals("Truck")) {
                        truck.refuel(value);
                    } else if (vehicleType.equals("Bus")) {
                        bus.refuel(value);
                    }
                } else if (command.equals("DriveEmpty")) {
                    bus.setEmpty(true);
                    System.out.println(bus.drive(value));
                } else {
                    break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static Vehicles createVehicle(Scanner scanner) {
        String[] lines = scanner.nextLine().split("\\s+");

        String vehicleType = lines[0];
        double fuelQuantity = Double.parseDouble(lines[1]);
        double fuelConsumption = Double.parseDouble(lines[2]);
        double tankCapacity = Double.parseDouble(lines[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus":
                return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
            default:
                return null;
        }
    }
}
