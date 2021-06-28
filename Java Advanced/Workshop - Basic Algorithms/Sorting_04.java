package Workshop;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        arr = bubbleSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        return arr;
    }
}