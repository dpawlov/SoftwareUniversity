package MidExamSoftuni;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsProducedPerDay = Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());
        int competingFactoryBiscuitsCount = Integer.parseInt(scanner.nextLine());

        int totalBiscuitsFor30Days = Math.round(0);

        for (int day = 1; day <= 30 ; day++) {
            if (day % 3 == 0) {
                totalBiscuitsFor30Days += (biscuitsProducedPerDay * workersCount) * 0.75;
            } else {
                totalBiscuitsFor30Days += biscuitsProducedPerDay * workersCount;
            }
        }
        System.out.printf("You have produced %d biscuits for the past month.%n", totalBiscuitsFor30Days);

        int differenceBetweenFactories = totalBiscuitsFor30Days - competingFactoryBiscuitsCount;

        double percentageDifference = 1.0 * differenceBetweenFactories / competingFactoryBiscuitsCount * 100;

        if ( percentageDifference > 0) {
            System.out.printf("You produce %.2f percent more biscuits.", percentageDifference);
        } else if (percentageDifference < 0) {
            System.out.printf("You produce %.2f percent less biscuits.", Math.abs(percentageDifference));
        }
    }
}
