package ListsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");

        List <Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < input.length ; i++) {
            String stringInput = input[i];
            numbersList.add(Integer.parseInt(stringInput));
        }
        for (int index = 0; index < numbersList.size() - 1; index++) {
            if (index == numbersList.size()) {
                break;
            }
            int currentElement = numbersList.get(index);
            int oppositeElement = numbersList.get(numbersList.size() - 1);

            numbersList.set(index, currentElement + oppositeElement);
            numbersList.remove(numbersList.size() - 1);
        }

        for (int i = 0; i < numbersList.size(); i++) {
            Integer numbers = numbersList.get(i);
            System.out.print(numbers + " ");
        }




    }
}
