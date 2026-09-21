public class DSA14 {

    public static void main(String[] args) {

        int n = 5;

        String result = "1";

        for (int i = 1; i < n; i++) {

            String next = "";

            int count = 1;

            for (int j = 1; j < result.length(); j++) {

                if (result.charAt(j) == result.charAt(j - 1)) {

                    count++;

                } else {

                    next = next + count + result.charAt(j - 1);

                    count = 1;
                }
            }

            next = next + count + result.charAt(result.length() - 1);

            result = next;
        }

        System.out.println("Count and Say: " + result);
    }
}