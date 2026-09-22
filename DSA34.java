public class DSA34 {

    static int n = 4;

    static int[][] board = new int[n][n];

    static boolean isSafe(int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {

            if (board[i][j] == 1) {
                return false;
            }

            i--;
            j--;
        }

        // Check right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {

            if (board[i][j] == 1) {
                return false;
            }

            i--;
            j++;
        }

        return true;
    }

    static boolean solve(int row) {

        // All queens placed
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {

                board[row][col] = 1;

                if (solve(row + 1)) {
                    return true;
                }

                // Backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        if (solve(0)) {

            System.out.println("N-Queens Solution:");

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (board[i][j] == 1) {
                        System.out.print("Q ");
                    }
                    else {
                        System.out.print(". ");
                    }
                }

                System.out.println();
            }
        }
        else {
            System.out.println("No Solution");
        }
    }
}