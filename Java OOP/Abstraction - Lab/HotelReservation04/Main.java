package HotelReservation04;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2]);
        Discount discountType = Discount.valueOf(tokens[3]);

        PriceCalculator reservation = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f%n", reservation.calculatePrice(pricePerDay, numberOfDays, season, discountType));
    }
}