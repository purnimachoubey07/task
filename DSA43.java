public class DSA43 {

    static boolean canAllocate(int[] books,
                               int students,
                               int maxPages) {

        int studentCount = 1;
        int pages = 0;

        for (int i = 0; i < books.length; i++) {

            if (pages + books[i] <= maxPages) {

                pages = pages + books[i];
            }
            else {

                studentCount++;

                pages = books[i];

                if (studentCount > students) {
                    return false;
                }
            }
        }

        return true;
    }

    static int bookAllocation(int[] books, int students) {

        if (students > books.length) {
            return -1;
        }

        int low = books[0];
        int high = 0;

        for (int i = 0; i < books.length; i++) {

            high = high + books[i];

            if (books[i] > low) {
                low = books[i];
            }
        }

        int answer = high;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (canAllocate(books, students, mid)) {

                answer = mid;

                // Try smaller maximum
                high = mid - 1;
            }
            else {

                // Need more pages
                low = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] books = {12, 34, 67, 90};

        int students = 2;

        int answer = bookAllocation(books, students);

        System.out.println(
            "Minimum Maximum Pages: " + answer
        );
    }
}
