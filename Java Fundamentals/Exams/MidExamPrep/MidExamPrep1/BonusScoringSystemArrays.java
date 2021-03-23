package Exam1;

import java.util.Scanner;

public class BonusScoringSystemArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double[] eachStudentBonus = new double[studentsCount];
        double maxBonus = eachStudentBonus[0];
        int studentWithMostAttendancies = 0;

        for (int i = 0; i < eachStudentBonus.length; i++) {

            int currentStudentAttendance = Integer.parseInt(scanner.nextLine());

            if (currentStudentAttendance > studentWithMostAttendancies) {
                studentWithMostAttendancies = currentStudentAttendance;
            }

            eachStudentBonus[i] = (currentStudentAttendance * 1.0 / lecturesCount) * (5 + additionalBonus);

            if (eachStudentBonus[i] > maxBonus) {
                maxBonus = eachStudentBonus[i];
            }

        }

        System.out.printf("Max Bonus: %.0f.", Math.ceil(maxBonus));
        System.out.println();
        System.out.printf("The student has attended %d lectures.", studentWithMostAttendancies);
    }
}
