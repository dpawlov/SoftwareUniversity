package Regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Map<String, Integer> racersDistance = new LinkedHashMap<>();

        names.forEach(input -> racersDistance.put(input, 0));

        String regexName = "[A-Za-z]+";
        Pattern patternName = Pattern.compile(regexName);

        String regexDistance = "[0-9]";
        Pattern patternDistance = Pattern.compile(regexDistance);

        String inputs = scanner.nextLine();

        while (!inputs.equals("end of race")) {
            Matcher matcherName = patternName.matcher(inputs);

            StringBuilder buildName = new StringBuilder();
            while (matcherName.find()) {
                buildName.append(matcherName.group());
            }
            String name = buildName.toString();


            Matcher matcherDistance = patternDistance.matcher(inputs);
            int totalDistance = 0;
            while (matcherDistance.find()) {
                totalDistance += Integer.parseInt(matcherDistance.group());
            }
            if (racersDistance.containsKey(name)) {
                racersDistance.put(name, racersDistance.get(name) + totalDistance);
            }

            inputs = scanner.nextLine();

        }

        List<String> firstThreeRacers = racersDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThreeRacers.get(0));
        System.out.println("2nd place: " + firstThreeRacers.get(1));
        System.out.println("3rd place: " + firstThreeRacers.get(2));
    }
}

