import java.util.Arrays;
import java.util.Scanner;

public class DSA2 {

    public static void moveZeros(int[] arr) {

        int index = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill remaining positions with zero
        while (index < arr.length) {
            arr[index] = 0;
            index++;
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

        moveZeros(arr);

        System.out.println("Array after moving zeros to end:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}








