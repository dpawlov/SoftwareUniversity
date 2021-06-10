package RawData04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        getCars();

        String cargoType = scanner.nextLine();

        switch (cargoType) {
            case "fragile":
                cars.stream()
                        .filter(car -> car.getCargoType().equals("fragile"))
                        .filter(Car::isValidTierPressure)
                        .forEach(System.out::println);
                break;
            case "flamable":
                cars.stream()
                        .filter(car -> car.getCargoType().equals("flamable"))
                        .filter(Car::isValidEnginePower)
                        .forEach(System.out::println);
                break;
        }

    }

    private static void getCars() throws IOException {
        int carsNumber = Integer.parseInt(scanner.nextLine());
        while (carsNumber-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            cars.add(new Car(tokens));
        }
    }
}