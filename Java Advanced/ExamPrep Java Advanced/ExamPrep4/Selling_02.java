package ExamPrep4;

import java.util.Scanner;

public class Selling_02 {
    public static int startRow = 0, startCol = 0;
    public static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
        }


        boolean isWithinBakery = true;
        while (money < 50 && isWithinBakery) {
            //TODO
//            if outOfBounds{
//                break;
//            }
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    isWithinBakery = move(startRow - 1, startCol, matrix);
                    break;
                case "down":
                    isWithinBakery = move(startRow + 1, startCol, matrix);
                    break;
                case "left":
                    isWithinBakery = move(startRow, startCol - 1, matrix);
                    break;
                case "right":
                    isWithinBakery = move(startRow, startCol + 1, matrix);
                    break;
            }

        }


        String message = !isWithinBakery
                ? "Bad news, you are out of the bakery."
                : "Good news! You succeeded in collecting enough money!";

        System.out.println(message);
        System.out.println("Money: " + money);
        printTheMatrix(matrix);
    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {

        matrix[startRow][startCol] = '-';

        if (isOutOfBounds(newRow, newCol, matrix)) {
            return false;
        }

        char symbol = matrix[newRow][newCol];
        if (Character.isDigit(symbol)) {
            money += symbol - '0';
        } else if (symbol == 'O') {
            matrix[newRow][newCol] = '-';
            int[] secondPillarLocation = findSecondPillar(matrix);
            newRow = secondPillarLocation[0];
            newCol = secondPillarLocation[1];

        }
        matrix[newRow][newCol] = 'S';

        startRow = newRow;
        startCol = newCol;
        return true;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0
                || col >= matrix[row].length || col < 0;
    }

    public static int[] findSecondPillar(char[][] matrix) {
        int[] indexes = null;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'O') {
                    indexes = new int[]{r, c};
                    break;
                }
            }
            if (indexes != null) {
                break;
            }
        }
        return indexes;
    }

    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}