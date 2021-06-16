package GenericBoxOfInteger_02;

import GenericBox_01.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<Integer> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }
        System.out.println(box);
    }
}
