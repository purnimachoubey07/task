import java.util.Arrays;

public class DSA12 {

    public static void main(String[] args) {

        String[] words = {
            "eat", "tea", "tan", "ate", "nat", "bat"
        };

        boolean[] used = new boolean[words.length];

        System.out.println("Anagram Groups:");

        for (int i = 0; i < words.length; i++) {

            if (used[i]) {
                continue;
            }

            System.out.print("[ " + words[i] + " ");

            char[] first = words[i].toCharArray();
            Arrays.sort(first);

            used[i] = true;

            for (int j = i + 1; j < words.length; j++) {

                if (used[j]) {
                    continue;
                }

                char[] second = words[j].toCharArray();
                Arrays.sort(second);

                if (Arrays.equals(first, second)) {

                    System.out.print(", " + words[j]);

                    used[j] = true;
                }
            }

            System.out.println(" ]");
        }
    }
}