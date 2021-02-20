package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();


        int size = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < size; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
        }

        printRest(firstList, size);
        printRest(secondList, size);
    }

    private static void printRest(List<Integer> numbers, int beginIndex) {
        for (int i = beginIndex; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");

        }
    }
}
