import java.util.*;

public class DSA50 {

    static int wordLadder(String start,
                           String end,
                           ArrayList<String> words) {

        HashSet<String> set =
            new HashSet<>(words);

        if (!set.contains(end)) {
            return 0;
        }

        Queue<String> queue =
            new LinkedList<>();

        queue.add(start);

        HashSet<String> visited =
            new HashSet<>();

        visited.add(start);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.remove();

                if (current.equals(end)) {
                    return level;
                }

                char[] characters =
                    current.toCharArray();

                for (int j = 0;
                     j < characters.length;
                     j++) {

                    char original = characters[j];

                    for (char ch = 'a';
                         ch <= 'z';
                         ch++) {

                        characters[j] = ch;

                        String newWord =
                            new String(characters);

                        if (set.contains(newWord) &&
                            !visited.contains(newWord)) {

                            visited.add(newWord);

                            queue.add(newWord);
                        }
                    }

                    characters[j] = original;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        String start = "hit";

        String end = "cog";

        ArrayList<String> words =
            new ArrayList<>();

        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");

        int result =
            wordLadder(start, end, words);

        if (result != 0) {

            System.out.println(
                "Shortest Word Ladder Length: "
                + result
            );
        }
        else {
            System.out.println(
                "No Transformation Possible"
            );
        }
    }
}