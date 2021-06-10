package SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")) {

            int indexOf = input.indexOf(", ");

            String command = input.substring(0, indexOf);
            String registrationPlate = input.substring(indexOf + 2);

            if (command.equals("IN")) {
                parkingLot.add(registrationPlate);
            } else {
                parkingLot.remove(registrationPlate);
            }
            input = scanner.nextLine();

        }
        String output = String.join(System.lineSeparator(), parkingLot);
        if (output.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(output);
        }
    }
}