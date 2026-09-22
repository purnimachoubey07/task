public class DSA37 {

    static int[] arr = {2, 3, 7, 8, 10};

    static boolean subsetSum(int index, int sum, int target) {

        // Target found
        if (sum == target) {
            return true;
        }

        // Array finished
        if (index == arr.length) {
            return false;
        }

        // Include current element
        if (subsetSum(index + 1,
                      sum + arr[index],
                      target)) {

            return true;
        }

        // Exclude current element
        if (subsetSum(index + 1,
                      sum,
                      target)) {

            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int target = 11;

        if (subsetSum(0, 0, target)) {
            System.out.println("Subset Found");
        }
        else {
            System.out.println("Subset Not Found");
        }
    }
}