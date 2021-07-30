import java.util.Scanner;

public class EnterNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int firstNumber = Integer.parseInt(scanner.nextLine());
            int secondNumber = Integer.parseInt(scanner.nextLine());
            printNumbers(firstNumber, secondNumber);
        }
        catch (NumberFormatException e) {
            System.out.println("Illegal format exception");
        }

    }

    public static void printNumbers(int start, int end) {
        if (1 < start && end > start && end < 100) {
            System.out.println("Valid numbers entered");
        } else {
            System.out.println("Invalid numbers entered");
        }
    }
}
