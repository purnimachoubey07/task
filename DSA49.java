import java.util.*;

public class DSA49 {

    static boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        // -1 means not colored
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {

            // Start a new component
            if (color[start] == -1) {

                Queue<Integer> queue =
                    new LinkedList<>();

                queue.add(start);

                color[start] = 0;

                while (!queue.isEmpty()) {

                    int current = queue.remove();

                    for (int neighbor : graph[current]) {

                        // Not colored
                        if (color[neighbor] == -1) {

                            color[neighbor] =
                                1 - color[current];

                            queue.add(neighbor);
                        }

                        // Same color
                        else if (color[neighbor] ==
                                 color[current]) {

                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };

        if (isBipartite(graph)) {
            System.out.println("Graph is Bipartite");
        }
        else {
            System.out.println("Graph is Not Bipartite");
        }
    }
}