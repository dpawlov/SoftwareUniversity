package PointInRectangle02;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoords = getCoords(scanner);

        Point topLeft = new Point(rectangleCoords[0], rectangleCoords[1]);
        Point bottomRight = new Point(rectangleCoords[2], rectangleCoords[3]);

        Rectangle rectangle = new Rectangle(topLeft, bottomRight);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            int[] pointCoords = getCoords(scanner);

            Point point = new Point(pointCoords[0], pointCoords[1]);

            System.out.println(rectangle.contains(point));
        }
    }

    private static int[] getCoords(Scanner scanner) throws IOException {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
