package DataTypesAndVariables;

import java.util.Scanner;

public class ConvertMetersToKM_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double km = Double.parseDouble(scanner.nextLine());

        double m = km / 1000;

        System.out.printf("%.2f", m);
    }

}

