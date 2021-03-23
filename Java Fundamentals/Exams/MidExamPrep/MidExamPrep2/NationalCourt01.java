package Exam2;

import java.util.Scanner;

public class NationalCourt01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());

        int totalCapacity = firstEmployee + secondEmployee + thirdEmployee;

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hours = 0;

        while (studentsCount > 0) {
            hours++;
            if (hours % 4 == 0) {
                hours++;
            }
            studentsCount = studentsCount - totalCapacity;
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
