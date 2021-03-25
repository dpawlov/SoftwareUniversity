package Exam3;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        double totalNumbersSum = 0;

        if (numbersArray.size() <= 1 || numbersArray.size() < 0 || numbersArray.size() == 0) {
            System.out.println("No");
        }

        for (int i = 0; i < numbersArray.size(); i++) {
            totalNumbersSum += numbersArray.get(i);
        }
        double averageNumber = totalNumbersSum / (double) numbersArray.size();

        List <Integer> greaterNumberList = new ArrayList<>();

        for (int i = 0; i < numbersArray.size(); i++) {
            if (numbersArray.get(i) > averageNumber) {
                greaterNumberList.add(0,numbersArray.get(i));
            }
        }
        Collections.sort(greaterNumberList, Collections.reverseOrder());

        if (greaterNumberList.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Integer integer = greaterNumberList.get(i);
                System.out.print(integer + " ");
            }
        } else {
            for (Integer number : greaterNumberList) {
                System.out.print(number + " ");
            }
        }


    }
}