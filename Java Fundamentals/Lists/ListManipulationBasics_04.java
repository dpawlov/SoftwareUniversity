package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String [] tokens = input.split("\\s+");

            String command = tokens[0];
            String number = tokens[1];


            if (command.equals("Add")) {
                listOfNumbers.add(Integer.parseInt(number));
            } else if (command.equals("Remove")) {
                listOfNumbers.remove(Integer.parseInt(number));
            } else if (command.equals("RemoveAt")) {
                listOfNumbers.remove(Integer.parseInt(number));
            } else if (command.equals("Insert")) {
                String index = tokens[2];
                listOfNumbers.add(Integer.parseInt(index), Integer.parseInt(number));
            }

            input = scanner.nextLine();
        }

        for (Integer numbers : listOfNumbers) {
            System.out.print(numbers + " ");
        }

    }
}