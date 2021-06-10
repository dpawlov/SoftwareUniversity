package CarSalesman05;

import java.io.IOException;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Car> cars = new ArrayList<>();
    private static Map<String, Engine> engines = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        getEngines();
        getCars();

        cars.forEach(System.out::println);
    }

    private static void getCars() throws IOException {
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engines.get(tokens[1]);
            switch (tokens.length) {
                case 4:
                    cars.add(new Car(model, engine, tokens[2], tokens[3]));
                    break;
                case 3:
                    cars.add(new Car(model, engine, tokens[2]));
                    break;
                case 2:
                    cars.add(new Car(model, engine));
                    break;
            }
        }
    }

    private static void getEngines() throws IOException {
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            String power = tokens[1];
            switch (tokens.length) {
                case 2:
                    engines.put(model, new Engine(model, power));
                    break;
                case 3:
                    engines.put(model, new Engine(model, power, tokens[2]));
                    break;
                case 4:
                    engines.put(model, new Engine(model, power, tokens[2], tokens[3]));
                    break;
            }
        }
    }
}