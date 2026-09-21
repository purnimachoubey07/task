import java.util.Stack;

public class DSA13 {

    public static void main(String[] args) {

        String str = "{[()]}";

        Stack<Character> stack = new Stack<>();

        boolean valid = true;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {

                stack.push(ch);

            } else {

                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(' ||
                    ch == ']' && top != '[' ||
                    ch == '}' && top != '{') {

                    valid = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            valid = false;
        }

        if (valid) {
            System.out.println("Valid Parentheses");
        } else {
            System.out.println("Invalid Parentheses");
        }
    }
}