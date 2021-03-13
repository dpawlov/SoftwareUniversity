package AssociativeArrays;

import java.util.*;

public class StudentAcademy07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> students = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(studentName)) {
                students.put(studentName, grade);
            } else {
                Double average = ((students.get(studentName) + grade) / 2);
                students.put(studentName, average);
            }
        }
        students.entrySet()
                .stream()
                .filter(a->a.getValue()>=4.5)
                .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(grade -> {
                    System.out.printf("%s -> %.2f%n", grade.getKey(), grade.getValue());
                });
    }
}