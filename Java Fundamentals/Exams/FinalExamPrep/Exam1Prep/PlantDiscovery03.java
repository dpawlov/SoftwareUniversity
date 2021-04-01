package Exam1;

import java.util.*;

public class PlantDiscovery03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> plantRarityByName = new HashMap<>();
        Map<String, List<Integer>> plantListOfRatingsByName = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] nameAndRarity = scanner.nextLine().split("<->");
            String plantName = nameAndRarity[0];

            plantRarityByName.put(plantName, Integer.parseInt(nameAndRarity[1]));
            plantListOfRatingsByName.put(plantName, new ArrayList<>());
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {
            String[] commandAndParameters = command.split(": ");


            switch (commandAndParameters[0]) {
                case "Rate":
                    String[] rateParameters = commandAndParameters[1].split(" - ");
                    String ratePlantName = rateParameters[0];
                    int rating = Integer.parseInt(rateParameters[1]);

                    List<Integer> ratings = plantListOfRatingsByName.get(ratePlantName);
                    if (ratings != null) {
                        ratings.add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "Update":
                    String[] updateParameters = commandAndParameters[1].split(" - ");
                    String updatePlantName = updateParameters[0];
                    int rarity = Integer.parseInt(updateParameters[1]);

                    if (plantRarityByName.containsKey(updatePlantName)) {
                        plantRarityByName.put(updatePlantName, rarity);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "Reset":
                    String resetPlantName = commandAndParameters[1];

                    List<Integer> resetRatings = plantListOfRatingsByName.get(resetPlantName);

                    if (resetRatings != null) {
                        resetRatings.clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantRarityByName.entrySet().stream().sorted((a, b) -> {
            int aRarity = a.getValue();
            int bRarity = b.getValue();

            if (aRarity != bRarity) {
                return Integer.compare(bRarity, aRarity);
            } else {
                double aRating = 0;
                List<Integer> aRatingsList = plantListOfRatingsByName.get(a.getKey());
                List<Integer> bRatingsList = plantListOfRatingsByName.get(b.getKey());
                double aAverageRating = calculateAverage(aRatingsList);
                double bAverageRating = calculateAverage(bRatingsList);

                return Double.compare(bAverageRating, aAverageRating);
            }
        })
                .map(entry -> "- " + entry.getKey() + "; Rarity: " + entry.getValue() + "; Rating: " + String.format("%.2f", calculateAverage(plantListOfRatingsByName.get(entry.getKey()))))
                .forEach(s -> System.out.println(s));

    }

    static double calculateAverage(List<Integer> number) {
        if (number.isEmpty()) {
            return 0;
        }
        double sum = 0;

        for (Integer integer : number) {
            sum += integer;
        }

        return sum / number.size();
    }
}
