package MethodsLab;

import java.util.Scanner;

public class CalculateRectangleArea_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());

        rectangleArea(height, width);
        System.out.println(rectangleArea(height, width));
    }

    private static int rectangleArea(int a, int b) {
        return a * b;
    }
}
