public class DSA16 {

    public static void main(String[] args) {

        String text = "AABACAADA";
        String pattern = "ACA";

        int n = text.length();
        int m = pattern.length();

        int prime = 101;

        int patternHash = 0;
        int textHash = 0;

        int power = 1;

        for (int i = 0; i < m - 1; i++) {
            power = (power * 256) % prime;
        }

        // Hash of pattern and first window
        for (int i = 0; i < m; i++) {

            patternHash =
                    (256 * patternHash + pattern.charAt(i)) % prime;

            textHash =
                    (256 * textHash + text.charAt(i)) % prime;
        }

        for (int i = 0; i <= n - m; i++) {

            if (patternHash == textHash) {

                boolean found = true;

                for (int j = 0; j < m; j++) {

                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    System.out.println("Pattern found at index: " + i);
                }
            }

            // Calculate next window hash
            if (i < n - m) {

                textHash =
                        (256 * (textHash
                        - text.charAt(i) * power)
                        + text.charAt(i + m)) % prime;

                if (textHash < 0) {
                    textHash = textHash + prime;
                }
            }
        }
    }
}