import java.util.Stack;

public class DSA29 {

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight;

            if (i == heights.length) {
                currentHeight = 0;
            }
            else {
                currentHeight = heights[i];
            }

            while (!stack.empty() &&
                   currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;

                if (stack.empty()) {
                    width = i;
                }
                else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }

            stack.push(i);
        }

        System.out.println("Largest Rectangle Area: " + maxArea);
    }
}