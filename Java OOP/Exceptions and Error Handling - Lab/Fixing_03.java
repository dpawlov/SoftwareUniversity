import java.util.Scanner;

public class Fixing_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] weekdays = new String[5];

        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[3] = "Wednesday";
        weekdays[4] = "Thursday";
        weekdays[4] = "Friday";
        weekdays[5] = "Saturday";
        weekdays[6] = "Sunday";

        for (int i = 0; i < weekdays.length; i++) {
            try {
                System.out.println(weekdays[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
