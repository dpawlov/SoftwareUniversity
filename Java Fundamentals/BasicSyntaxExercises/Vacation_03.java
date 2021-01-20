package BasicSyntaxEcercise;

import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double price = 0;

        switch (dayOfWeek) {
            case "Friday":
                switch (type) {
                    case "Students":
                        price = 8.45;
                        break;
                    case "Business":
                        price = 10.90;
                        break;
                    case "Regular":
                        price = 15;
                        break;
                }
                break;
            case "Saturday":
                switch (type) {
                    case "Students":
                        price = 9.80;
                        break;
                    case "Business":
                        price = 15.60;
                        break;
                    case "Regular":
                        price = 20;
                        break;
                }
                break;
            case "Sunday":
                switch (type) {
                    case "Students":
                        price = 10.46;
                        break;
                    case "Business":
                        price = 16;
                        break;
                    case "Regular":
                        price = 22.50;
                        break;
                }

                break;
        }

        double totalPrice = count * price;

        if(type.equals("Students") && count >= 30) {
            totalPrice *= 0.85;
        } else if (type.equals("Business") && count >= 100) {
            totalPrice -= 10 * price;
        } else if (type.equals("Regular") && count >= 10 &&  count <= 20) {
            totalPrice *= 0.95;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
