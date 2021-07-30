import java.util.Scanner;

public class SquareRoot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());
            squareInt(number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }
        finally {
            System.out.println("Goodbye");
        }
    }

    public static void squareInt(int number) {
        System.out.println(number * number);
    }
}
