public class DSA17 {

    public static void main(String[] args) {

        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int[] lps = new int[pattern.length()];

        int length = 0;
        int i = 1;

        // Create LPS array
        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(length)) {

                length++;
                lps[i] = length;
                i++;

            } else {

                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Search pattern
        i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;

            }

            if (j == pattern.length()) {

                System.out.println(
                    "Pattern found at index: " + (i - j)
                );

                j = lps[j - 1];

            } else if (i < text.length()
                    && text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }
}