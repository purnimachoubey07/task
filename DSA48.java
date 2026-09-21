import java.util.*;

public class DSA48 {

    static boolean canFinish(int courses, int[][] prerequisites) {

        // Step 1: Create graph
        ArrayList<Integer>[] graph = new ArrayList[courses];

        for (int i = 0; i < courses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: Create indegree array
        int[] indegree = new int[courses];

        // Step 3: Fill graph and indegree
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph[prerequisite].add(course);

            indegree[course]++;
        }

        // Step 4: Create queue
        Queue<Integer> queue = new LinkedList<>();

        // Step 5: Add courses having indegree 0
        for (int i = 0; i < courses; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 6: Count completed courses
        int completed = 0;

        // Step 7: BFS
        while (!queue.isEmpty()) {

            int current = queue.remove();

            completed++;

            for (int next : graph[current]) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // Step 8: Check all courses completed
        return completed == courses;
    }

    public static void main(String[] args) {

        int courses = 2;

        int[][] prerequisites = {
                { 1, 0 }
        };

        if (canFinish(courses, prerequisites)) {
            System.out.println("Courses can be completed");
        } else {
            System.out.println("Courses cannot be completed");
        }
    }
}