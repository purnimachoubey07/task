public class DSA41 {

    static int findPeak(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = (low + high) / 2;

            // Right side is increasing
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            else {
                // Peak is on left side or at mid
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 4, 2};

        int index = findPeak(arr);

        System.out.println("Peak Element: " + arr[index]);
        System.out.println("Peak Index: " + index);
    }
}