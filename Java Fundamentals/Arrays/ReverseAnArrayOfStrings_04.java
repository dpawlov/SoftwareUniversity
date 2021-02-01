package Arrays;

import java.util.Scanner;

public class ReverseAnArrayOfStrings_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] arrayAsString = scanner.nextLine().split(" ");

        for (int i = 0; i < arrayAsString.length / 2; i++) {

            int swapIndex = arrayAsString.length - i - 1;

            String tmp = arrayAsString[i];
            arrayAsString[i] = arrayAsString [swapIndex];
            arrayAsString[swapIndex] = tmp;

        }

        for (int i = 0; i < arrayAsString.length; i++) {
            System.out.print(arrayAsString[i] + " ");
        }
    }
}
