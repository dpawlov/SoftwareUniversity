package Exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String places = scanner.nextLine();
        String regex = "([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1";

        Pattern patter = Pattern.compile(regex);
        Matcher matcher = patter.matcher(places);

        int travelPoints = 0;
        List<String> locations = new ArrayList<>();

        while (matcher.find()) {
            String destinations = matcher.group("destination");
            travelPoints += destinations.length();
            locations.add(destinations);
        }

        System.out.println("Destinations: " + String.join(", ", locations));
        System.out.println("Travel Points: " + travelPoints);
    }
}
