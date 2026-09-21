import java.util.*;

public class DSA47 {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static void zigzagTraversal(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        boolean leftToRight = true;

        System.out.println("Zigzag Traversal:");

        while (!queue.isEmpty()) {

            int size = queue.size();

            int[] level = new int[size];

            for (int i = 0; i < size; i++) {

                Node current = queue.remove();

                if (leftToRight) {
                    level[i] = current.data;
                }
                else {
                    level[size - 1 - i] = current.data;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            for (int i = 0; i < size; i++) {
                System.out.print(level[i] + " ");
            }

            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        zigzagTraversal(root);
    }
}