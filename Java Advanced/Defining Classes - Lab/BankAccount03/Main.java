package BankAccount03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        String line;

        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    System.out.println(String.format("Account ID%d created", bankAccount.getId()));
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);

                    if (bankAccountMap.containsKey(id)) {
                        bankAccountMap.get(id).deposit(amount);
                        System.out.println(String.format("Deposited %.0f to ID%d", amount, id));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double rate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(rate);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (bankAccountMap.containsKey(id)) {
                        double interest = bankAccountMap.get(id).getInterest(years);
                        System.out.println(String.format("%.2f", interest));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
        }
    }
}