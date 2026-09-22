import java.util.Stack;

public class DSA27 {

    public static void main(String[] args) {

        String expression = "2 3 + 4 *";

        Stack<Integer> stack = new Stack<>();

        String[] parts = expression.split(" ");

        for (int i = 0; i < parts.length; i++) {

            String part = parts[i];

            if (part.equals("+") ||
                part.equals("-") ||
                part.equals("*") ||
                part.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                if (part.equals("+")) {
                    result = a + b;
                }
                else if (part.equals("-")) {
                    result = a - b;
                }
                else if (part.equals("*")) {
                    result = a * b;
                }
                else if (part.equals("/")) {
                    result = a / b;
                }

                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(part));
            }
        }

        System.out.println("Postfix Result: " + stack.pop());
    }
}