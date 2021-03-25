package Exam3;

import java.util.Scanner;

public class SoftUniReception01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employee1 = Integer.parseInt(scanner.nextLine());
        int employee2 = Integer.parseInt(scanner.nextLine());
        int employee3 = Integer.parseInt(scanner.nextLine());
        int totalEmployeeCapacity = employee1 + employee2 + employee3;
        int studentsRemaining = Integer.parseInt(scanner.nextLine());

        int hours = 0;

        while(studentsRemaining > 0) {
            hours++;
            studentsRemaining = studentsRemaining - totalEmployeeCapacity;
            if(hours % 4 == 0) {
                hours++;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}

