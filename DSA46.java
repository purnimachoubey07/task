import java.util.*;

public class DSA46 {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {

        Node node;
        int column;

        Pair(Node node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    static void verticalOrder(Node root) {

        if (root == null) {
            return;
        }

        HashMap<Integer, ArrayList<Integer>> map =
            new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        int minColumn = 0;
        int maxColumn = 0;

        while (!queue.isEmpty()) {

            Pair current = queue.remove();

            Node node = current.node;
            int column = current.column;

            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<>());
            }

            map.get(column).add(node.data);

            if (node.left != null) {

                queue.add(
                    new Pair(node.left, column - 1)
                );

                if (column - 1 < minColumn) {
                    minColumn = column - 1;
                }
            }

            if (node.right != null) {

                queue.add(
                    new Pair(node.right, column + 1)
                );

                if (column + 1 > maxColumn) {
                    maxColumn = column + 1;
                }
            }
        }

        System.out.println("Vertical Order:");

        for (int i = minColumn; i <= maxColumn; i++) {

            ArrayList<Integer> list = map.get(i);

            for (int value : list) {
                System.out.print(value + " ");
            }
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

        verticalOrder(root);
    }
}