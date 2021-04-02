package Exam5Prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Astra_Ad02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<separator>[|#])(?<product>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,4})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> productCalories = new ArrayList<>();
        int totalCalories = 0;

        while (matcher.find()) {
            productCalories.add(String.format("Item: %s, Best before: %s, Nutrition: %d",
                    matcher.group("product"),
                    matcher.group("date"),
                    Integer.parseInt(matcher.group("calories"))));

            totalCalories += Integer.parseInt(matcher.group("calories"));
        }
        int limitDays = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", limitDays);
        productCalories.forEach(System.out::println);

    }
}
