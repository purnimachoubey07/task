public class DSA33 {

    static int n = 4;

    static int[][] maze = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {0, 1, 1, 1}
    };

    static int[][] solution = new int[n][n];

    static boolean solveMaze(int row, int col) {

        // Destination reached
        if (row == n - 1 && col == n - 1) {
            solution[row][col] = 1;
            return true;
        }

        // Check valid position
        if (row >= 0 && row < n &&
            col >= 0 && col < n &&
            maze[row][col] == 1 &&
            solution[row][col] == 0) {

            solution[row][col] = 1;

            // Move Down
            if (solveMaze(row + 1, col)) {
                return true;
            }

            // Move Right
            if (solveMaze(row, col + 1)) {
                return true;
            }

            // Move Up
            if (solveMaze(row - 1, col)) {
                return true;
            }

            // Move Left
            if (solveMaze(row, col - 1)) {
                return true;
            }

            // Backtrack
            solution[row][col] = 0;
        }

        return false;
    }

    public static void main(String[] args) {

        if (solveMaze(0, 0)) {

            System.out.println("Path Found:");

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    System.out.print(solution[i][j] + " ");
                }

                System.out.println();
            }
        }
        else {
            System.out.println("No Path Found");
        }
    }
}