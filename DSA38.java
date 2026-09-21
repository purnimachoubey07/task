public class DSA38 {

    static int[] arr = {1, 2, 3};

    static void printSubsets(int index, String subset) {

        // All elements processed
        if (index == arr.length) {

            System.out.println("{" + subset + "}");

            return;
        }

        // Include current element
        String newSubset;

        if (subset.equals("")) {
            newSubset = "" + arr[index];
        }
        else {
            newSubset = subset + ", " + arr[index];
        }

        printSubsets(index + 1, newSubset);

        // Exclude current element
        printSubsets(index + 1, subset);
    }

    public static void main(String[] args) {

        System.out.println("All Subsets:");

        printSubsets(0, "");
    }
}