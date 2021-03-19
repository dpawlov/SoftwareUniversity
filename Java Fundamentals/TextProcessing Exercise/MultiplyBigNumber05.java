package TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reallyBigInteger = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());

        if (number == 0) {
            System.out.println(0);
            return;
        }

        while (reallyBigInteger.charAt(0) == '0') {
            reallyBigInteger = reallyBigInteger.substring(1);
        }


        StringBuilder sb = new StringBuilder();
        int reminder = 0;

        for (int i = reallyBigInteger.length() - 1; i >= 0 ; i--) {
            int digit = Integer.parseInt(String.valueOf(reallyBigInteger.charAt(i)));
            int result = digit * number + reminder;
            reminder = 0;
            if (result > 9) {
                reminder = result / 10;
                result = result % 10;
            }
            sb.append(result);
        }
        if (reminder != 0) {
            sb.append(reminder);
        }
        System.out.println(sb.reverse().toString());
    }
}
