package ExEncapsulation01;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = new Box(length, width, height);
        double surfaceArea = box.calculateSurfaceArea();
        double lateralArea = box.calculateLateralSurfaceArea();
        double volume = box.calculateVolume();


        System.out.printf("Surface Area - %.2f\n", surfaceArea);
        System.out.printf("Lateral Area - %.2f\n", lateralArea);
        System.out.printf("Volume - %.2f", volume);
    }
}

