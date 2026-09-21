public class DSA15 {

    public static void main(String[] args) {

        String str = "AABABBA";

        int k = 1;

        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {

            int[] count = new int[26];

            int maxFrequency = 0;

            for (int j = i; j < str.length(); j++) {

                char ch = str.charAt(j);

                count[ch - 'A']++;

                if (count[ch - 'A'] > maxFrequency) {
                    maxFrequency = count[ch - 'A'];
                }

                int length = j - i + 1;

                int replacements = length - maxFrequency;

                if (replacements <= k) {

                    if (length > maxLength) {
                        maxLength = length;
                    }

                } else {
                    break;
                }
            }
        }

        System.out.println(
            "Longest Repeating Character Length: " + maxLength
        );
    }
}