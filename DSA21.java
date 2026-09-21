public class DSA21 {

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

        int k = 2;

        for (int i = 0; i < k; i++) {

            Node temp = head;

            while (temp.next.next != null) {
                temp = temp.next;
            }

            Node last = temp.next;

            temp.next = null;

            last.next = head;

            head = last;
        }

        Node current = head;

        System.out.println("Rotated Linked List:");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}