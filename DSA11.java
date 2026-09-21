public class DSA11 {

    public static void main(String[] args) {

        String str = "abcabcbb";

        int maxLength = 0;
        String longest = "";

        for (int i = 0; i < str.length(); i++) {

            String current = "";

            for (int j = i; j < str.length(); j++) {

                char ch = str.charAt(j);

                boolean found = false;

                for (int k = 0; k < current.length(); k++) {

                    if (current.charAt(k) == ch) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    break;
                }

                current = current + ch;

                if (current.length() > maxLength) {
                    maxLength = current.length();
                    longest = current;
                }
            }
        }

        System.out.println("Longest Substring: " + longest);
        System.out.println("Length: " + maxLength);
    }
}