public class DSA18 {

    public static void main(String[] args) {

        String str = "ADOBECODEBANC";
        String pattern = "ABC";

        int[] required = new int[256];

        for (int i = 0; i < pattern.length(); i++) {
            required[pattern.charAt(i)]++;
        }

        int[] current = new int[256];

        int left = 0;
        int count = 0;

        int minLength = str.length() + 1;
        int start = 0;

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);

            current[ch]++;

            if (required[ch] > 0
                    && current[ch] <= required[ch]) {
                count++;
            }

            while (count == pattern.length()) {

                int length = right - left + 1;

                if (length < minLength) {

                    minLength = length;
                    start = left;
                }

                char leftChar = str.charAt(left);

                current[leftChar]--;

                if (required[leftChar] > 0
                        && current[leftChar] < required[leftChar]) {
                    count--;
                }

                left++;
            }
        }

        if (minLength == str.length() + 1) {
            System.out.println("Window not found");
        } else {
            System.out.println(
                "Smallest Window: "
                + str.substring(start, start + minLength)
            );
        }
    }
}