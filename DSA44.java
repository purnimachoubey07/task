public class DSA44 {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node findLCA(Node root, int a, int b) {

        // Root is null
        if (root == null) {
            return null;
        }

        // Root is one of the required nodes
        if (root.data == a || root.data == b) {
            return root;
        }

        Node leftResult = findLCA(root.left, a, b);

        Node rightResult = findLCA(root.right, a, b);

        // Both sides contain a node
        if (leftResult != null && rightResult != null) {
            return root;
        }

        // Return whichever side has a result
        if (leftResult != null) {
            return leftResult;
        }

        return rightResult;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int a = 4;
        int b = 5;

        Node lca = findLCA(root, a, b);

        System.out.println(
            "LCA of " + a + " and " + b + ": " + lca.data
        );
    }
}