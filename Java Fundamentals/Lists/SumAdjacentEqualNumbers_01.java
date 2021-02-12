package ListsLab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<Double> list = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            String stringInput = input[i];
            list.add(Double.parseDouble(stringInput));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            double sum = 0;
            if (list.get(i).equals(list.get(i + 1))) {
                sum = list.get(i) + list.get(i + 1);
                list.set(i, sum);
                list.remove(i + 1);
                i = -1;
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.#");

        for (Double numbers : list) {
            System.out.print(decimalFormat.format(numbers) + " ");
        }
    }
}
