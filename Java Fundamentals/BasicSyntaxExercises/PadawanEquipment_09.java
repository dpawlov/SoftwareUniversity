package BasicSyntaxEcercise;

import java.util.Scanner;

public class PadawanEquipment_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceLightsabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double totalPriceSabers = priceLightsabers * Math.ceil(students * 1.1);
        double totalPriceRobes = students * priceRobes;
        double totalPriceBelts = (students - students / 6) * priceBelts;

        double totalPrice = totalPriceBelts + totalPriceRobes + totalPriceSabers;
        if (totalPrice <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", totalPrice - money);
        }

    }
}


