public class DSA36 {

    static char[][] grid = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };

    static String word = "ABCCED";

    static boolean search(int row, int col, int index) {

        // Word complete
        if (index == word.length()) {
            return true;
        }

        // Check boundaries
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {

            return false;
        }

        // Character does not match
        if (grid[row][col] != word.charAt(index)) {
            return false;
        }

        // Store current character
        char temp = grid[row][col];

        // Mark as visited
        grid[row][col] = '#';

        // Down
        if (search(row + 1, col, index + 1)) {
            return true;
        }

        // Up
        if (search(row - 1, col, index + 1)) {
            return true;
        }

        // Right
        if (search(row, col + 1, index + 1)) {
            return true;
        }

        // Left
        if (search(row, col - 1, index + 1)) {
            return true;
        }

        // Backtrack
        grid[row][col] = temp;

        return false;
    }

    public static void main(String[] args) {

        boolean found = false;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (search(i, j, 0)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        if (found) {
            System.out.println("Word Found");
        }
        else {
            System.out.println("Word Not Found");
        }
    }
}