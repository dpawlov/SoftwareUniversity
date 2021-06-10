package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashSet<String> vips = new LinkedHashSet<>();
        LinkedHashSet<String> regulars = new LinkedHashSet<>();

        while (!input.equals("PARTY")) {

            if(Character.isDigit(input.charAt(0))) {
                vips.add(input);
            } else {
                regulars.add(input);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        TreeSet<String> allGuests = new TreeSet<>(vips);
        allGuests.addAll(regulars);

        while (!input.equals("END")) {
            allGuests.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(allGuests.size());

        System.out.println(String.join(System.lineSeparator(), allGuests));
    }
}
