package Articles02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(",\\s+");
        int n = Integer.parseInt(sc.nextLine());

        Article article = new Article(arr[0], arr[1], arr[2]);

        for (int i = 0; i < n; i++) {
            arr = sc.nextLine().split(": ");

            switch (arr[0]) {
                case "Edit":
                    article.edit(arr[1]);
                    break;

                case "ChangeAuthor":
                    article.changeAuthor(arr[1]);
                    break;

                case "Rename":
                    article.rename(arr[1]);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
