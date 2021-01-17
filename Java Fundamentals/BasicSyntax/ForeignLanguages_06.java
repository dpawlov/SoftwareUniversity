package BasicSyntax;

import java.util.Scanner;

public class ForeignLanguages_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String language = scanner.nextLine();

        switch (language) {
            case "USA":
            case "England":
                System.out.println("English");
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
        }

    }
}

