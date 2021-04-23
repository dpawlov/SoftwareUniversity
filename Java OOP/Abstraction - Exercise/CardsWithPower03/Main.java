package CardsWithPower03;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        System.out.println(String.format("Card name: %s of %s; Card power: %d",
                RankPowers.valueOf(rank), SuitPowers.valueOf(suit),
                RankPowers.valueOf(rank).getValue() + SuitPowers.valueOf(suit).getValue()
        ));
    }
}