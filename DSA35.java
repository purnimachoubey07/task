public class DSA35 {

    static void generate(String result, int open, int close, int n) {

        // Complete string
        if (result.length() == n * 2) {

            System.out.println(result);
            return;
        }

        // Add opening bracket
        if (open < n) {

            generate(result + "(", open + 1, close, n);
        }

        // Add closing bracket
        if (close < open) {

            generate(result + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println("Balanced Parentheses:");

        generate("", 0, 0, n);
    }
}