import java.util.Stack;

public class DSA28 {

    static int priority(char ch) {

        if (ch == '+' || ch == '-') {
            return 1;
        }

        if (ch == '*' || ch == '/') {
            return 2;
        }

        if (ch == '^') {
            return 3;
        }

        return 0;
    }

    public static void main(String[] args) {

        String expression = "A+B*C";

        Stack<Character> stack = new Stack<>();

        String postfix = "";

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Operand
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {

                postfix = postfix + ch;
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                while (!stack.empty() && stack.peek() != '(') {
                    postfix = postfix + stack.pop();
                }

                stack.pop();
            }

            // Operator
            else {

                while (!stack.empty() &&
                       priority(stack.peek()) >= priority(ch)) {

                    postfix = postfix + stack.pop();
                }

                stack.push(ch);
            }
        }

        while (!stack.empty()) {
            postfix = postfix + stack.pop();
        }

        System.out.println("Infix Expression: " + expression);
        System.out.println("Postfix Expression: " + postfix);
    }
}