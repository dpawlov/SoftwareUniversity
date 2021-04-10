package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')') {
                int openingIndex = stack.pop();
                int closingIndex = i;
                System.out.println(expression.substring(openingIndex, closingIndex + 1));
            }
        }
    }
}
