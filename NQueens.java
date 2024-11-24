import java.util.Scanner;

public class NQueens {

    public static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int row, int N) {
        if (row >= N) {
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col, N)) {
                board[row][col] = 1;

                if (solveNQueens(board, row + 1, N)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of N (number of queens): ");
        int N = sc.nextInt();

        int[][] board = new int[N][N];

        if (solveNQueens(board, 0, N)) {
            System.out.println("Solution for " + N + " Queens:");
            printBoard(board, N);
        } else {
            System.out.println("No solution exists for " + N + " Queens.");
        }

        sc.close();
    }
}
