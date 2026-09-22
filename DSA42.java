import java.util.Arrays;

public class DSA42 {

    static boolean canPlace(int[] stalls, int cows, int distance) {

        int count = 1;

        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= distance) {

                count++;

                lastPosition = stalls[i];

                if (count == cows) {
                    return true;
                }
            }
        }

        return false;
    }

    static int aggressiveCows(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1]
                 - stalls[0];

        int answer = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (canPlace(stalls, cows, mid)) {

                answer = mid;

                // Try bigger distance
                low = mid + 1;
            }
            else {

                // Distance is too large
                high = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] stalls = {1, 2, 4, 8, 9};

        int cows = 3;

        int answer = aggressiveCows(stalls, cows);

        System.out.println(
            "Maximum Minimum Distance: " + answer
        );
    }
}