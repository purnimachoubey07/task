public class DSA23 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;

        Node first = head;
        Node second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        if (first == null) {
            head = head.next;
        } else {

            while (first.next != null) {
                first = first.next;
                second = second.next;
            }

            second.next = second.next.next;
        }

        System.out.println("Linked List:");

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}