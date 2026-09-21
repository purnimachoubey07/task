public class DSA45 {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);

        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        int difference = leftHeight - rightHeight;

        if (difference > 1 || difference < -1) {
            return -1;
        }

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        }
        else {
            return rightHeight + 1;
        }
    }

    static boolean isBalanced(Node root) {

        return height(root) != -1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        if (isBalanced(root)) {
            System.out.println("Tree is Balanced");
        }
        else {
            System.out.println("Tree is Not Balanced");
        }
    }
}