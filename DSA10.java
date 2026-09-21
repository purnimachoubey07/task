public class DSA10 {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};

        System.out.println("Union:");

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        for (int i = 0; i < arr2.length; i++) {

            boolean found = false;

            for (int j = 0; j < arr1.length; j++) {

                if (arr2[i] == arr1[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.print(arr2[i] + " ");
            }
        }

        System.out.println();


        System.out.println("Intersection:");

        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr2.length; j++) {

                if (arr1[i] == arr2[j]) {

                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
    }
}