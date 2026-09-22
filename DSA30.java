import java.util.ArrayDeque;
import java.util.Deque;

public class DSA30 {

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};

        int k = 3;

        Deque<Integer> deque = new ArrayDeque<>();

        System.out.print("Sliding Window Maximum: ");

        for (int i = 0; i < arr.length; i++) {

            // Remove elements outside the window
            while (!deque.isEmpty() &&
                   deque.peekFirst() <= i - k) {

                deque.removeFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() &&
                   arr[deque.peekLast()] <= arr[i]) {

                deque.removeLast();
            }

            deque.addLast(i);

            // Print maximum when window is ready
            if (i >= k - 1) {

                System.out.print(arr[deque.peekFirst()] + " ");
            }
        }
    }
}