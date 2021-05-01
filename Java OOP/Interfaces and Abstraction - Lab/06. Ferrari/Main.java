package Interfaces06lab;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Ferrari ferrari = new Ferrari(input);

        System.out.println(ferrari.toString());
    }
}