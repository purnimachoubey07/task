import java.util.Arrays;
import java.util.Scanner;

public class DSA1 {

    public static void rotateArray(int[] arr, int k) {

        int n = arr.length;

        // If k is greater than array length
        k = k % n;

        // Reverse complete array
        reverse(arr, 0, n - 1);

        // Reverse first k elements
        reverse(arr, 0, k - 1);

        // Reverse remaining elements
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        rotateArray(arr, k);

        System.out.println("Array after rotation:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}