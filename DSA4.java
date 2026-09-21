public class DSA4 {

    public static void main(String[] args) {

        int[] arr = {1, 4, 20, 3, 10, 5};
        int target = 33;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum = sum + arr[j];

                if (sum == target) {

                    System.out.println("Subarray found:");

                    for (int k = i; k <= j; k++) {
                        System.out.print(arr[k] + " ");
                    }

                    return;
                }
            }
        }

        System.out.println("Subarray not found");
    }
}