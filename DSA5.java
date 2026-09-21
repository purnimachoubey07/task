public class DSA5 {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 2, 2};

        for (int i = 0; i < arr.length; i++) {

            int leftSum = 0;
            int rightSum = 0;

            // Left side sum
            for (int j = 0; j < i; j++) {
                leftSum = leftSum + arr[j];
            }

            // Right side sum
            for (int j = i + 1; j < arr.length; j++) {
                rightSum = rightSum + arr[j];
            }

            if (leftSum == rightSum) {

                System.out.println("Equilibrium Index: " + i);
                return;
            }
        }

        System.out.println("Equilibrium Index not found");
    }
}