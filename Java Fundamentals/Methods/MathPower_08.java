package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        double powNum = Double.parseDouble(scanner.nextLine());

        System.out.println(new DecimalFormat("0.###").format(Math.pow(number, powNum)));

    }

    private static double raisedNumber(double number, double power) {
        double result = 1;

        result =  Math.pow(number, power);

        return result;


    }
}
