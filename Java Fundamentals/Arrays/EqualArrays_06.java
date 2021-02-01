package Arrays;

import java.util.Scanner;

public class EqualArrays_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] firstArrayAsString = scanner.nextLine().split(" ");
        String [] secondArrayAsString = scanner.nextLine().split(" ");

        int [] firstArray = new int [firstArrayAsString.length];
        int [] secondArray = new int [secondArrayAsString.length];

        int sum = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (!firstArrayAsString[i].equals(secondArrayAsString[i])) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            }
            firstArray[i] = Integer.parseInt(firstArrayAsString[i]);
            sum += firstArray[i];
         }
        System.out.printf("Arrays are identical. Sum: %d", sum);

    }
}
